package com.ehk.controller.hospital;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ehk.exception.BusinessException;
import com.ehk.model.hospital.Hospital;
import com.ehk.service.hospital.HospitalService;
import com.ehk.util.HMSLogger;
import com.ehk.validator.HospitalValidator;
import com.ehk.vo.hospital.DepartmentVo;
import com.ehk.vo.hospital.DistrictVo;
import com.ehk.vo.hospital.GenderVo;
import com.ehk.vo.hospital.HospitalVisitVo;
import com.ehk.vo.hospital.HospitalVo;
import com.ehk.vo.hospital.PatientVo;

@Controller
public class HospitalController {

	//private static final Logger logger = Logger.getLogger(HospitalController.class);
	@HMSLogger
	Logger hmsLogger;
	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private HospitalValidator hospitalValidator;

	@RequestMapping(value = { "/", "/index" })
	public String home(Model model) throws IOException {
		hmsLogger.info("index page");
		return "index";
	}

	@RequestMapping(value = "/hospital")
	public String listEmployee(Model model) throws IOException {
		hmsLogger.info("hospital page");
		List<HospitalVo> listHospital = hospitalService.getAllHospital();
		model.addAttribute("listHospital", listHospital);
		return "hospital";
	}

	@RequestMapping(value = "/createHospital", method = RequestMethod.GET)
	public String createHospital(Model model) {
		hmsLogger.info("createHospital page");
		HospitalVo hospitalVo = new HospitalVo();
		List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
		hospitalVo.setDistrictList(districtList);
		model.addAttribute("hospitalVo", hospitalVo);
		return "HospitalForm";
	}

	@RequestMapping(value = "/saveHospital", method = { RequestMethod.POST, RequestMethod.GET })
	public RedirectView saveHospital(@ModelAttribute HospitalVo hospitalVo, RedirectAttributes redir) {
		hospitalService.saveAndUpdateHospital(hospitalVo);
		RedirectView redirectView = new RedirectView("/hospital", true);
		redir.addFlashAttribute("message", "Hospital Updated Successfully");
		return redirectView;
	}

	@RequestMapping(value = "/deleteHospital", method = RequestMethod.GET)
	public String deleteHospital(@RequestParam("id") int hospitalId) {
		// int hospitalId = Integer.parseInt(request.getParameter("id"));
		hospitalService.deleteHospital(hospitalId);
		return "redirect:/";
	}

	@RequestMapping(value = "/editHospital", method = RequestMethod.GET)
	public String editHospital(@RequestParam("id") int hospitalId, Model model) {
		// int hospitalId = Integer.parseInt(request.getParameter("id"));
		List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
		HospitalVo hospitalVo = hospitalService.getHospital(hospitalId);
		hospitalVo.setDistrictList(districtList);
		model.addAttribute("hospitalVo", hospitalVo);

		return "HospitalForm";
	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.GET)
	public String createPatient(Model model) {
		PatientVo patientVo = new PatientVo();
		// List<GenderVo> genderVoList = hospitalService.getGenderMasterList();
		List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
		patientVo.setDistrictList(districtList);
		model.addAttribute("patientVo", patientVo);

		return "PatientForm";
	}

	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public String savePatient(@Valid @ModelAttribute("patientVo") PatientVo patientVo, BindingResult bindingResult,
			RedirectAttributes redir, @RequestParam("file") MultipartFile file, HttpServletRequest request,
			Model model) {
		// Date
		String saveDirectory = "D:\\upload/";
		RedirectView redirectView = new RedirectView();
		hospitalValidator.validate(patientVo, bindingResult);
		if (bindingResult.hasErrors()) {
			/*
			 * redir.addFlashAttribute(
			 * "org.springframework.validation.BeanPropertyBindingResult", bindingResult);
			 * redir.addFlashAttribute("patientVo", patientVo); redirectView= new
			 * RedirectView("/createPatient",true); redir.addFlashAttribute(
			 * "org.springframework.validation.BindingResult.patientVo", bindingResult);
			 * redir.addFlashAttribute("patientVo", patientVo);
			 */
			List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
			patientVo.setDistrictList(districtList);
			redir.addFlashAttribute("patientVo", patientVo);
			return "PatientForm";
		}
		// String saveDirectory =
		// request.getSession().getServletContext().getRealPath("/Uploads/");
		try {
			Files.createDirectories(Paths.get(saveDirectory));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String fileName = file.getOriginalFilename();
		if (fileName != null) {
			/*
			 * long millis = System.currentTimeMillis(); String sig =
			 * Long.toHexString(millis);
			 */
			// String random = UUID.randomUUID().toString();
			String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String uniqueFileName = fileSuffix + "_" + fileName;
			try {
				file.transferTo(new File(saveDirectory + uniqueFileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block

			}
			patientVo.setPatient_image(uniqueFileName);
		}
		hospitalService.saveAndUpdatePatient(patientVo);
		redirectView = new RedirectView("/listPatient", true);
		redir.addFlashAttribute("message", "Patient Updated Successfully");
		// model.addAttribute("message", "Patient Updated Successfully");
		return "redirect:/listPatient";
	}

	@RequestMapping(value = "/listPatient")
	public String listPatient(Model model) throws IOException {
		List<PatientVo> patientList = hospitalService.getAllPatient();
		model.addAttribute("patientList", patientList);
		return "PatientList";
	}

	@RequestMapping(value = "/editPatient", method = RequestMethod.GET)
	public String editPatient(@RequestParam("id") int patientId, Model model) {
		List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
		PatientVo patientVo = hospitalService.getPatientByPatientId(patientId);
		patientVo.setDistrictList(districtList);
		String saveDirectory = "D:\\upload/";
		Path source = Paths.get(saveDirectory + patientVo.getPatient_image());

		BufferedImage bi;
		try {
			bi = ImageIO.read(source.toFile());
			// convert BufferedImage to byte[]
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", baos);
			byte[] bytes = baos.toByteArray();
			String fileBase64 = Base64.getEncoder().encodeToString(bytes);
			patientVo.setPatient_image(fileBase64);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(BusinessException e){
			hmsLogger.error(e.getMessage());
			throw new BusinessException(e.getMessage(),e.getCause());
		}

		model.addAttribute("patientVo", patientVo);

		return "PatientForm";
	}

	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public String deletePatient(@RequestParam("id") int patientId) {
		// @RequestParam
		// int patientId = Integer.parseInt(request.getParameter("id"));
		hospitalService.deletePatient(patientId);
		return "redirect:/listPatient";
	}

	@RequestMapping(value = "/hsopitalVisit", method = RequestMethod.GET)
	public String hsopitalVisitForm(Model model) {
		HospitalVisitVo hospitalVisitVo = new HospitalVisitVo();
		List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
		hospitalVisitVo.setDistrictList(districtList);

		List<PatientVo> patientList = hospitalService.getAllPatient();
		List<HospitalVo> hospitalList = hospitalService.getAllHospital();
		hospitalVisitVo.setHospitalList(hospitalList);
		hospitalVisitVo.setPatientList(patientList);
		model.addAttribute("hospitalVisitVo", hospitalVisitVo);
		return "HospitalVisitForm";
	}

	@RequestMapping(value = "/hsopitalVisit", method = { RequestMethod.POST })
	public RedirectView createHospitalVisit(@ModelAttribute HospitalVisitVo hospitalVisitVo, RedirectAttributes redir) {
		hospitalService.createHospitalVisit(hospitalVisitVo);
		RedirectView redirectView = new RedirectView("/hsopitalVisit", true);
		redir.addFlashAttribute("message", "Visit Created Successfully");
		return redirectView;
	}

	@RequestMapping(value = "getHospitalByDistrict", method = RequestMethod.POST)
	@ResponseBody
	public List<HospitalVo> getHospitalByDistrict(@RequestParam int districtId) {
		List<HospitalVo> hospitalList = new ArrayList<HospitalVo>();
		//logger.info("getHospitalByDistrict() in HospitalController Started");
		if (districtId != 0) {
			hospitalList = hospitalService.getHospitalByDistrict(districtId);
		}
		return hospitalList;

	}

	@RequestMapping(value = "/createDepartment", method = RequestMethod.GET)
	public String createDepartment(Model model) {
		DepartmentVo departmentVo = new DepartmentVo();
		List<DistrictVo> districtList = hospitalService.getDistrictByStateId();
		departmentVo.setDistrictList(districtList);
		model.addAttribute("departmentVo", departmentVo);
		return "DepartmentForm";
	}

	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	public RedirectView saveDepartment(@ModelAttribute DepartmentVo departmentVo, RedirectAttributes redir) {
		hospitalService.saveDepartment(departmentVo);
		RedirectView redirectView = new RedirectView("/createDepartment", true);
		redir.addFlashAttribute("message", "Department Saved Successfully");
		return redirectView;
	}

	@RequestMapping(value = "getDepartmentByHospital", method = RequestMethod.POST)
	@ResponseBody
	public List<DepartmentVo> getDepartmentByHospital(@RequestParam int hospitalId) {
		List<DepartmentVo> departmentList = new ArrayList<DepartmentVo>();
		//logger.info("getDepartmentByHospital() in HospitalController Started");
		if (hospitalId != 0) {
			departmentList = hospitalService.getDepartmentByHospital(hospitalId);
		}
		return departmentList;

	}

}
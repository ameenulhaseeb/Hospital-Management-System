<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<style>

.container {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script type="text/javascript"
	src="${contextPath}/resources/js/jquery214.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hospital Visit</title>
<script>
$('select').selectpicker();
</script>
</head>
<body>
	     <div class="text-right" style="margin:10px;">
     <a href="index" class="btn btn-success">Home</a>
  </div>
  	<c:if test="${not empty message}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Success!</strong> ${message}
			</div>

		</c:if>
	<div class="container">
	
	<div class="col-12 col-lg-6 col-xl-7" style="background-color: lightgrey;">
		
		
					<h3 class="mb-0">Hospital Visit</h3>
				
					<form:form action="hsopitalVisit" method="post"
						modelAttribute="hospitalVisitVo">


				 	 	<div class="form-group">
								<label for="inputPassword3">District</label>
								<form:select class="form-control" path="district.district_id"
									multiple="false" onchange="changeDistrict(this.value)">
									<option value="0" >--Select--</option>
									<form:options items="${hospitalVisitVo.districtList}"
										itemValue="district_id" itemLabel="district_name" />
								</form:select>
							</div>  
						<div class="form-group">
							<label for="inputPassword3">Hospital</label>
							<form:select class="form-control" id="hospital" path="hospital.hospital_id"
								multiple="false" onchange="changeHospital(this.value)">
								<option value="0">--Select District First--</option>
							<%-- 	<form:options items="${hospitalVisitVo.hospitalList}"
									itemValue="hospital_id" itemLabel="hospital_name" /> --%>
							</form:select>
						</div>
						<div class="form-group">
							<label for="inputPassword3">Patient</label>
							<form:select class="form-control" path="patient.patient_id"
								multiple="false">
								<option value="0">--Select--</option>
								<form:options items="${hospitalVisitVo.patientList}"
									itemValue="patient_id" itemLabel="patient_name" />
							</form:select>
						</div>
								<div class="form-group">
							<label for="inputPassword3">Department</label>
							<form:select class="form-control selectpicker" id="department" multiple="multiple" data-live-search="true" path="deptSet">
							  
							</form:select>
						</div>

						<div class="form-group">
							<form:button class="btn btn-primary btn-lg float-right"
								type="submit">Save</form:button>
						</div>
					</form:form>
		
	</div>
	</div>
	<script>

	function changeDistrict(districtId){
		$('#department')
   	    .empty();
		$('.selectpicker').selectpicker('refresh');
   		$('#hospital')
   	    .empty()
   	    .append('<option selected="selected" value="">--Select--</option>'); 

   		if(districtId !="" && districtId !=null){
	   		var params = {
	   				districtId : districtId
				};
			$.ajax({
						url : "getHospitalByDistrict",
						data : params,
						type : "POST",
						
						success : function(res) {
							console.log(res)
							$.each(res, function(i, obj) {	
							
								$("#hospital").append('<option value='+obj.hospital_id+'>'+obj.hospital_name+'</option>');
							/*$('#hospital').append($('<option>',
									 {
									    value: obj[0],
									    text : obj[1]
									}));*/
							
							});
							
						/* 	res.forEach(workplace => {
							    $('#hospital.hospital_id').append($('<option>', {
							       value: workplace,
							       text: workplace
							    }));
							}) */
						},
						error : function(xhr, textStatus, errorThrown) {
							
						alert("Error")

						}

					});
			
	   		}
   		
   	}
	
function changeHospital(hospitalId){
   		
  		$('#department')
   	    .empty();
  		$('.selectpicker').selectpicker('refresh');
   		if(hospitalId !="" && hospitalId !=null){
	   		var params = {
	   				hospitalId : hospitalId
				};
			$.ajax({
						url : "getDepartmentByHospital",
						data : params,
						type : "POST",
						
						success : function(res) {
							console.log(res)
							$.each(res, function(i, obj) {	
							
								$("#department").append('<option value='+obj.department_id+'>'+obj.department_name+'</option>');
								$('.selectpicker').selectpicker('refresh');
				
							
							});
							
					
						},
						error : function(xhr, textStatus, errorThrown) {
							
						alert("Error")

						}

					});
			
	   		}
   		
   	}
</script>
</body>
</html>
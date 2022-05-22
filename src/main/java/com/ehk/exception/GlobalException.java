package com.ehk.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ehk.util.HMSLogger;



@ControllerAdvice
public class GlobalException {
	
	@HMSLogger
	Logger hmsLogger;

	@ExceptionHandler(BusinessException.class)
	public ModelAndView  processCustomException(BusinessException ud)
	{
		ModelAndView mav = new ModelAndView("error/errorPage");
		 mav.addObject("name", ud.getMessage());
	     mav.addObject("message", ud.getMessage());
	     hmsLogger.error(ud.getMessage());
	     return mav;
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView  processIOException(IOException ioe)
	{
		ModelAndView mav = new ModelAndView("exceptionPage");
		 mav.addObject("name", ioe.getMessage());
	     mav.addObject("message", ioe.getMessage());
	 
	     return mav;
	}
		
}

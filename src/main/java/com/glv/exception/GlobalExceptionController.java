package com.glv.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.glv.dto.response.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest req, Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

	@ExceptionHandler(value = AppException.class)
	@ResponseBody
	public ErrorInfo<String> stringExceptionHandler(HttpServletRequest req, Exception e) {
		ErrorInfo<String> errorInfo = new ErrorInfo<String>();
		errorInfo.setData("Errors ... ");
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setMessage(e.getMessage() == null ? "Error..." : e.getMessage());
		errorInfo.setUrl(req.getRequestURL().toString());
		return errorInfo;

	}

}

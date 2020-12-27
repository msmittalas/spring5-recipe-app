package io.mitts.springdemo.recipedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(value = {DataNotFoundException.class,BindException.class})
	public ModelAndView handleException(Exception exception)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("error");
		modelAndView.setStatus(HttpStatus.NOT_FOUND);
		return modelAndView;
	}
	
}

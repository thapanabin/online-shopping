package com.nabin.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
		@ExceptionHandler(NoHandlerFoundException.class)
		public ModelAndView handlerNoHandlerFoundException() {
			
			ModelAndView mv = new ModelAndView("error");
			
			mv.addObject("errorTitle", "The page is not constructed!");
			
			mv.addObject("errorDescription", "The page you are looking for is not avaiable now!");
			
			mv.addObject("title", "404 Error Page");
			
			return mv;
			
		}
		
		@ExceptionHandler(ProductNotFoundException.class)
		public ModelAndView handlerProductNotFoundException() {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle", "Product Not aaiable!");
			mv.addObject("errorDescription", "The product you are looking for is not avaiable right now");
			mv.addObject("title", "Product Unavaiable!");
			return mv;
		}
		
		@ExceptionHandler(Exception.class)
		public ModelAndView handlerException(Exception ex) {
			ModelAndView mv = new ModelAndView("error");
			
			mv.addObject("errorTitle", "Contact Administrator!!");
			
			/* only for debugging your application to display the trace to webpage generally it is displayed in the console */
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			
			mv.addObject("errorDescription",sw.toString());//we can do it by ex.toString() if we dont want to see trace
			
			mv.addObject("title", "Error!");
			
			return mv;
		}
	
}

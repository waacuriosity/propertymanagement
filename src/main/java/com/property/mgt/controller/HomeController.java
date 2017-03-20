package com.property.mgt.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class HomeController {
	
	@RequestMapping({"/"})
	public String home(){
		return "login";
	}

	@RequestMapping({"/welcome"})
	public String welcome(HttpServletRequest request,HttpServletResponse response, Locale locale) {
		// Her's how to Manually set Locale
	//	RequestContextUtils.getLocaleResolver(request).setLocale(request, response, Locale.ENGLISH);
		
		String origMessage = 
	            (String)request.getAttribute("javax.servlet.error.message");
		//System.out.printf("MESSAGE:  %s\n",origMessage);

  		//System.out.printf("WELCOME AGAIN %s in %s\n","Kemosabe!",locale.getDisplayLanguage());

		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		

		return "welcome";
	}
}

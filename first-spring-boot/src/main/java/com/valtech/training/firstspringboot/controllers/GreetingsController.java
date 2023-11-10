package com.valtech.training.firstspringboot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

//	@RequestMapping(method = RequestMethod.GET,path = "/hello")
//	@ResponseBody
	@GetMapping("/hello")
	public String hello( String name, Model model) {
//		return "HELLO Valtechies:SPRING-MVC";
//		String name=req.getParameter("name");
		System.out.println("Name:" + name);
		model.addAttribute("name", name);
		return "hello";
	}

}

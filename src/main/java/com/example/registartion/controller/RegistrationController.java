package com.example.registartion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.registartion.vo.RegistrationVO;

@RestController
public class RegistrationController {

	static List<RegistrationVO> database = new ArrayList<>(50);
	
	@GetMapping("/")
	public ModelAndView landingPage() {
		return new ModelAndView("registartion");
	}
	
	@PostMapping(value = {"/upload-form"})
	public ModelAndView registration(HttpServletRequest request) {
		RegistrationVO registrationVO = new RegistrationVO();
		registrationVO.setName(request.getParameter("name"));
		registrationVO.setEmail(request.getParameter("email"));
		registrationVO.setMobileNo(request.getParameter("mobileNo"));
		registrationVO.setDob(request.getParameter("dob"));
		database.add(registrationVO);
		ModelAndView model = new ModelAndView("success");
		model.addObject("data", database);
		return model;
	}
}

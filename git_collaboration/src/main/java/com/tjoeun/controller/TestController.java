package com.tjoeun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tjoeun.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/test1")
	public String test1(Model model) {
		String returnData = this.testService.testMethod1();
		System.out.println("returnData : " + returnData);
		model.addAttribute("returnData", returnData);
		return "test1";
	}

}

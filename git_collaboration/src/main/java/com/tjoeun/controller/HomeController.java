package com.tjoeun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tjoeun.dto.UserDTO;

@Controller
public class HomeController {
	
	@Resource(name="loginUserDTO")
	@Lazy
	private UserDTO loginUserDTO;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		System.out.println("안녕하세요 !~~ ");
		// System.out.println(loginUserDTO);
		System.out.println(request.getServletContext().getRealPath("/"));
		return "redirect:/main";
	  // return "home";
	}
	
}

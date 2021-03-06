/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;

@Controller
public class HomeController {



	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		model.addAttribute("username", "" );
		List<String> roles = SecurityUtils.getRolesOfUser();
		if (!CollectionUtils.isEmpty(roles) &&  roles.contains("ROLE_MANAGER")) {
			return "redirect:/manager/viewBooking";
		} else if(!CollectionUtils.isEmpty(roles) &&  roles.contains("ROLE_ADMIN")) {
			return "redirect:/admin/viewAccount";
		}
		return "home-user";
	}

	@RequestMapping("/login")
	public String loginPage(Model model, @RequestParam(value = "error", required = false) boolean error) {
		if (error) {
			model.addAttribute("message", "Login Fail!!!");
		}
		return "login";
	}
	

	@RequestMapping("/error")
	public String accessDenied(Model model) {
		return "error";
	}

	
}

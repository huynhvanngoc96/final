
package com.mycompany.spring_mvc_project_final.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.service.UserRoleService;
import com.mycompany.spring_mvc_project_final.service.UserService;

@Controller

@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/home")
	public String viewHome(Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}

		model.addAttribute("message", "Hello Admin: " + username);
		return "home-admin";
	}

	@GetMapping("/viewAccount")
	public String viewAccount(Model model) {
		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "admin/viewAccount";
	}

	@GetMapping("/addAccount")
	public String addAccount(Model model) {
		model.addAttribute("status", UserStatus.values());
		model.addAttribute("user", new UserEntity());
		model.addAttribute("userRoleList", userRoleService.findAll());
		return "admin/addAccount";
	}

	@PostMapping("/doAddAccount")
	public String doAddAccount(@Valid @ModelAttribute(name = "user") UserEntity user, BindingResult rs, Model model) {

		if (rs.hasErrors()) {
			List<UserEntity> userList = userService.findAll();
			model.addAttribute("userList", userList);
			model.addAttribute("status", UserStatus.values());
			
			  model.addAttribute("userRoleList", userRoleService.findAll());
			  return "admin/addAccount";
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);

		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);

		return "admin/viewAccount";
	}

	@GetMapping("/searchAccount")
	public String searchAccount(Model model, @RequestParam(name = "keyword") String keyword) {

		List<UserEntity> userList = userService.searchByName(keyword);
		model.addAttribute("userList", userList);
		return "admin/viewAccount";
	}

	@GetMapping("/updateAccount")
	public String updateAccount(Model model, @RequestParam(name = "id") int id) {
		Optional<UserEntity> opt_user = userService.findById(id);
		if (opt_user.isPresent()) {
			model.addAttribute("user", opt_user.get());
			model.addAttribute("status", UserStatus.values());
		} else {
			return "error";
		}

		return "admin/updateAccount";
	}

	@PostMapping("/doUpdateAccount")
	public String doUpdateAccount(@Valid @ModelAttribute(name = "user") UserEntity user, BindingResult rs,
			Model model) {
		if (rs.hasErrors()) {
			model.addAttribute("status", UserStatus.values());
			return "admin/updateAccount";
		}

		userService.save(user);
		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "admin/viewAccount";
	}

}

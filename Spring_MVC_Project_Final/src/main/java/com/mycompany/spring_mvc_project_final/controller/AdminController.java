/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.spring_mvc_project_final.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.mycompany.spring_mvc_project_final.entities.UserEntity;
//import com.mycompany.spring_mvc_project_final.enums.UserStatus;
//import com.mycompany.spring_mvc_project_final.service.UserService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//	@Autowired
//	UserService userService;
//
//    @RequestMapping("/home")
//    public String viewHome(Model model) {
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = principal.toString();
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        }
//
//        model.addAttribute("message", "Hello Admin: " + username);
//        return "admin/home";
//    }
//    
//    @GetMapping("/view-account")
//    public String viewAccount(Model model) {
//    	List<UserEntity> userList = userService.findAll();
//    	model.addAttribute("userList",userList );
//    	return "admin/view-account";
//    }
//    
//    @GetMapping("/account-detail")
//    public String addAccount(Model model) {
//    	model.addAttribute("status", UserStatus.values());
//    	model.addAttribute("user", new UserEntity());
//    	return "admin/account-detail";
//    }
//    
//    @PostMapping("/doAddAccount")
//    public String doAddAccount(@Valid @ModelAttribute(name="user") UserEntity user, BindingResult rs, Model model) {
//    	if(rs.hasErrors()) {
//    		model.addAttribute("status", UserStatus.values());
//    		return "admin/account-detail";
//    	}
//    	userService.save(user);
//    	return "admin/test";
//    }
//    
//    @GetMapping("/search")
//    public String search(Model model, @RequestParam(name="keyword") String keyword) {
//    	List<UserEntity> userList = userService.findByCriteria(keyword);
//    	model.addAttribute("userList", userList);
//    	return "admin/view-account";
//    }
//    
//    @GetMapping("/editAccount")
//    public String editAccount(Model model, @RequestParam(name="id") int id) {
//    	Optional <UserEntity> opt_user = userService.findById(id);
//    	if(opt_user.isPresent()) {
//    		model.addAttribute("user", opt_user.get());
//    		model.addAttribute("status", UserStatus.values());
//    	} else {
//    		return "error";
//    	}
//    	
//    	
//    	return "admin/edit-account";
//    }
//    
//    @PostMapping("/doEditAccount")
//    public String doEditAccount(@Valid @ModelAttribute(name="user") UserEntity user, BindingResult rs, Model model) {
//    	if(rs.hasErrors()) {
//    		model.addAttribute("status", UserStatus.values());
//    		return "admin/edit-account";
//    	}
//    	
//    	userService.save(user);
//    	List<UserEntity> userList = userService.findAll();
//    	model.addAttribute("userList",userList );
//    	return "admin/view-account";
//    }
//    
//   
//    
//    
//}
//	
//	/*
//	 * @RequestMapping("/home") public String viewHome(Model model) {
//	 * 
//	 * Object principal =
//	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
//	 * username = principal.toString(); if (principal instanceof UserDetails) {
//	 * username = ((UserDetails) principal).getUsername(); }
//	 * 
//	 * model.addAttribute("message", "Hello Admin: " + username); return
//	 * "admin/home"; }
//	 */
//    
//
//
//}

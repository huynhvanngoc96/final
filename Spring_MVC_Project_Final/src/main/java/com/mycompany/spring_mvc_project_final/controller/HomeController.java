/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.spring_mvc_project_final.entities.ImageEntity;
import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomCategoryEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.enums.RoomCategoryStatus;
import com.mycompany.spring_mvc_project_final.service.ImageService;
import com.mycompany.spring_mvc_project_final.service.PromotionService;
import com.mycompany.spring_mvc_project_final.service.RoomCategoryService;
import com.mycompany.spring_mvc_project_final.service.RoomService;
import com.mycompany.spring_mvc_project_final.service.ServiceDetailsHandling;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;


@Controller
public class HomeController {

	@Autowired
	RoomCategoryService roomCategoryService;

	@Autowired
	RoomService roomService;

	@Autowired
	ServiceDetailsHandling serviceDetailsHandling;

	@Autowired
	PromotionService promotionService;

	@Autowired
	ImageService imageService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		List<String> roles = SecurityUtils.getRolesOfUser();
		if (!CollectionUtils.isEmpty(roles)
				&& (roles.contains("ROLE_ADMIN") || roles.contains("ROLE_SELLER") || roles.contains("ROLE_MANAGER"))) {
			return "redirect:/admin/home-management";
		}
		return "home-management";
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

	@GetMapping("/viewCategory")
	public String viewCategory(Model model) {

		List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
		model.addAttribute("roomCategoryList", roomCategoryList);

		return "admin/viewCategory";
	}

	@GetMapping("/addCategory")
	public String addCategory(Model model) {

		RoomCategoryEntity roomCategory = new RoomCategoryEntity();
		model.addAttribute("roomCategory", roomCategory);

		return "admin/addCategory";
	}

	@PostMapping("/doAddCategory")
	public String doAddCategory(@Valid @ModelAttribute(name = "roomCategory") RoomCategoryEntity roomCategory,
			BindingResult rs, Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
			model.addAttribute("roomCategoryList", roomCategoryList);
			return "admin/addCategory";
		} else {

			if (roomCategory.getImages() != null && roomCategory.getImages().length > 0) {
				roomCategory.setImageEntities(
						imageService.uploadImageCategory(roomCategory.getImages(), servletRequest, roomCategory));
			}
			roomCategory.setCreateDate(LocalDate.now());
			roomCategoryService.save(roomCategory);

			List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
			model.addAttribute("roomCategoryList", roomCategoryList);

			return "admin/viewCategory";
		}
	}

	@GetMapping("/deleteCategory")
	public String deleteCategory(Model model, @RequestParam(name = "id") int id) {

		roomCategoryService.deleteById(id);

		List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
		model.addAttribute("roomCategoryList", roomCategoryList);

		return "admin/viewCategory";

	}

	@GetMapping("/updateCategory")
	public String updateCategory(Model model, @RequestParam(name = "id") int id) throws Exception {

		RoomCategoryEntity opt_Category = roomCategoryService.findById(id);
		/* Optional<ImageEntity> opt_Image = imageService.findById(id); */
		if (opt_Category != null) {
			model.addAttribute("roomCategory", opt_Category);

			System.err.println(opt_Category.getImageEntities().size());
			return "admin/updateCategory";
		} else {
			return "error";
		}

	}

	@PostMapping("/doUpdateCategory")
	public String doUpdateCategory(@Valid @ModelAttribute(name = "roomCategory") RoomCategoryEntity roomCategory,
			BindingResult rs, Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
			model.addAttribute("roomCategoryList", roomCategoryList);
			return "admin/updateCategory";

		} else {
			roomCategory.setImageEntities(
					imageService.uploadImageCategory(roomCategory.getImages(), servletRequest, roomCategory));
		}

		roomCategoryService.save(roomCategory);

		List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
		model.addAttribute("roomCategoryList", roomCategoryList);

		System.err.println(roomCategory.getImageEntities().size());
		return "admin/viewCategory";
	}

	@GetMapping("/viewRoom")
	public String viewRoom(Model model) {

		List<RoomEntity> roomList = roomService.findAll();
		model.addAttribute("roomList", roomList);

		return "admin/viewRoom";
	}

	@GetMapping("/addRoom")
	public String addRoom(Model model) {

		List<RoomCategoryEntity> categoryList = roomCategoryService.findAll();
		
		model.addAttribute("room", new RoomEntity());
		model.addAttribute("categoryList", categoryList);
		return "admin/addRoom";
	}

	@PostMapping("/doAddRoom")
	public String doAddRoom(@Valid @ModelAttribute(name = "room") RoomEntity room, BindingResult rs, Model model) {

		if (rs.hasErrors()) {
			List<RoomEntity> roomList = roomService.findAll();
			model.addAttribute("roomList", roomList);
			return "admin/addRoom";
		}
		roomService.save(room);

		List<RoomEntity> roomList = roomService.findAll();
		model.addAttribute("roomList", roomList);

		return "admin/viewRoom";
	}

	@GetMapping("/viewService")
	public String viewService(Model model) {

		List<ServiceEntity> serviceList = serviceDetailsHandling.findAll();
		model.addAttribute("serviceList", serviceList);

		return "admin/viewService";
	}

	@GetMapping("/addService")
	public String addService(Model model) {

		model.addAttribute("service", new ServiceEntity());

		return "admin/addService";
	}

	@PostMapping("/doAddService")
	public String doAddService(@Valid @ModelAttribute(name = "service") ServiceEntity service, BindingResult rs,
			Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<ServiceEntity> serviceList = serviceDetailsHandling.findAll();
			model.addAttribute("serviceList", serviceList);
			return "admin/addCategory";
		} else {

			if (service.getImages() != null && service.getImages().length > 0) {
				service.setImageEntities(imageService.uploadImageService(service.getImages(), servletRequest, service));
			}
			service.setCreateDate(LocalDate.now());
			serviceDetailsHandling.save(service);

			List<ServiceEntity> serviceList = serviceDetailsHandling.findAll();
			model.addAttribute("serviceList", serviceList);

			return "admin/viewService";
		}

	}

	@GetMapping("/viewPromotion")
	public String viewPromotion(Model model) {

		List<PromotionEntity> promotionList = promotionService.findAll();
		model.addAttribute("promotionList", promotionList);

		return "admin/viewPromotion";
	}

	@GetMapping("/addPromotion")
	public String addPromotion(Model model) {

		model.addAttribute("promotion", new PromotionEntity());

		return "admin/addPromotion";
	}

	@PostMapping("/doAddPromotion")
	public String doAddPromotion(@Valid @ModelAttribute(name = "promotion") PromotionEntity promotion, BindingResult rs,
			Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<PromotionEntity> promotionList = promotionService.findAll();
			model.addAttribute("promotionList", promotionList);
			return "admin/addPromotion";
		} else {

			if (promotion.getImages() != null && promotion.getImages().length > 0) {
				promotion.setImageEntities(
						imageService.uploadImagePromotion(promotion.getImages(), servletRequest, promotion));
			}
			promotion.setCreateDate(LocalDate.now());
			promotionService.save(promotion);

			List<PromotionEntity> promotionList = promotionService.findAll();
			model.addAttribute("promotionList", promotionList);

			return "admin/viewPromotion";
		}
	}

}

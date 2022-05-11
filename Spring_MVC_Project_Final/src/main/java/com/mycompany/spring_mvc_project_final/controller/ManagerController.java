/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.spring_mvc_project_final.dto.RoomDto;
import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomCategoryEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.enums.RoomStatus;
import com.mycompany.spring_mvc_project_final.service.BookingDetailsService;
import com.mycompany.spring_mvc_project_final.service.BookingService;
import com.mycompany.spring_mvc_project_final.service.ImageService;
import com.mycompany.spring_mvc_project_final.service.PromotionService;
import com.mycompany.spring_mvc_project_final.service.RoomCategoryService;
import com.mycompany.spring_mvc_project_final.service.RoomService;
import com.mycompany.spring_mvc_project_final.service.ServiceBookingService;
import com.mycompany.spring_mvc_project_final.service.ServiceService;
import com.mycompany.spring_mvc_project_final.service.UserDetailsServiceImpl;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	RoomCategoryService roomCategoryService;

	@Autowired
	RoomService roomService;

	@Autowired
	ServiceService serviceService;

	@Autowired
	PromotionService promotionService;

	@Autowired
	ImageService imageService;

	@Autowired
	UserDetailsServiceImpl userService;

	@Autowired
	BookingService bookingService;

	@Autowired
	BookingDetailsService bookingDetailsService;

	@Autowired
	ServiceBookingService serviceBookingService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

  @RequestMapping("/home")
  public String viewHome(Model model) {

      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String username = principal.toString();
      if (principal instanceof UserDetails) {
          username = ((UserDetails) principal).getUsername();
      }

      model.addAttribute("message",  username);
      
      return "home-management";
  }


	// Room Category
	@GetMapping("/viewCategory")
	public String viewCategory(Model model) {

		model.addAttribute("roomCategoryList", roomCategoryService.findAll());

		return "manager/viewCategory";
	}

	@GetMapping("/searchCategory")
	public String searchCategory(Model model, @RequestParam(value = "search") String search) {

		model.addAttribute("roomCategoryList", roomCategoryService.searchByName(search));

		return "manager/viewCategory";
	}

	@GetMapping("/addCategory")
	public String addCategory(Model model) {

		RoomCategoryEntity roomCategory = new RoomCategoryEntity();
		model.addAttribute("roomCategory", roomCategory);

		return "manager/addCategory";
	}

	@PostMapping("/doAddCategory")
	public String doAddCategory(@Valid @ModelAttribute(name = "roomCategory") RoomCategoryEntity roomCategory,
			BindingResult rs, Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {

			model.addAttribute("roomCategoryList", roomCategoryService.findAll());

			return "manager/addCategory";
		} else {

			if (roomCategory.getImages() != null && roomCategory.getImages().length > 0) {
				roomCategory.setImageEntities(
						imageService.uploadImageCategory(roomCategory.getImages(), servletRequest, roomCategory));
			}
			roomCategory.setCreateDate(LocalDate.now());
			roomCategoryService.save(roomCategory);

			List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
			model.addAttribute("roomCategoryList", roomCategoryList);

			return "manager/viewCategory";
		}
	}

	@GetMapping("/deleteCategory")
	public String deleteCategory(Model model, @RequestParam(name = "id") int id) {

		roomCategoryService.deleteById(id);

		List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
		model.addAttribute("roomCategoryList", roomCategoryList);

		return "manager/viewCategory";

	}

	@GetMapping("/updateCategory")
	public String updateCategory(Model model, @RequestParam(name = "id") int id) throws Exception {

		RoomCategoryEntity opt_Category = roomCategoryService.findById(id);
		if (opt_Category != null) {
			model.addAttribute("roomCategory", opt_Category);

			return "manager/updateCategory";
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
			return "manager/updateCategory";

		} else {
			roomCategory.setImageEntities(
					imageService.uploadImageCategory(roomCategory.getImages(), servletRequest, roomCategory));
		}

		roomCategoryService.save(roomCategory);

		List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
		model.addAttribute("roomCategoryList", roomCategoryList);

		return "manager/viewCategory";
	}

	@GetMapping("/deleteImageCategory/{id}/{categoryId}")
	public String deleteImageCategory(Model model, @PathVariable(name = "id") int id,
			@PathVariable(name = "categoryId") int categoryId) {

		imageService.deleteImgCategory(categoryId, id);

		return "redirect:/manager/updateCategory?id=" + categoryId;
	}

	// Room
	@GetMapping("/viewRoom")
	public String viewRoom(Model model) {

		List<RoomEntity> roomList = roomService.findAll();
		model.addAttribute("roomList", roomList);

		return "manager/viewRoom";
	}

	@GetMapping("/addRoom")
	public String addRoom(Model model) {

		model.addAttribute("room", new RoomEntity());
		model.addAttribute("categoryList", roomCategoryService.findAll());
		model.addAttribute("status", RoomStatus.values());
		return "manager/addRoom";
	}

	@PostMapping("/doAddRoom")
	public String doAddRoom(@Valid @ModelAttribute(name = "room") RoomDto room, BindingResult rs, Model model) {

		if (rs.hasErrors()) {
			List<RoomCategoryEntity> categoryList = roomCategoryService.findAll();
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("roomList", room);
			model.addAttribute("status", RoomStatus.values());
			return "redirect:/addRoom";
		}

//		roomService.save(room);

		List<RoomEntity> roomList = roomService.findAll();
		model.addAttribute("roomList", roomList);

		return "redirect:/viewRoom";
	}

	// Service
	@GetMapping("/viewService")
	public String viewService(Model model) {

		List<ServiceEntity> serviceList = serviceService.findAll();
		model.addAttribute("serviceList", serviceList);

		return "manager/viewService";
	}

	@GetMapping("/addService")
	public String addService(Model model) {

		model.addAttribute("service", new ServiceEntity());

		return "manager/addService";
	}

	@PostMapping("/doAddService")
	public String doAddService(@Valid @ModelAttribute(name = "service") ServiceEntity service, BindingResult rs,
			Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<ServiceEntity> serviceList = serviceService.findAll();
			model.addAttribute("serviceList", serviceList);
			return "manager/addCategory";
		} else {

			if (service.getImages() != null && service.getImages().length > 0) {
				service.setImageEntities(imageService.uploadImageService(service.getImages(), servletRequest, service));
			}
			service.setCreateDate(LocalDate.now());
			serviceService.save(service);

			List<ServiceEntity> serviceList = serviceService.findAll();
			model.addAttribute("serviceList", serviceList);

			return "manager/viewService";
		}

	}

	@GetMapping("/deleteService")
	public String deleteService(Model model, @RequestParam(name = "id") int id) {

		serviceService.deleteById(id);

		List<ServiceEntity> serviceList = serviceService.findAll();
		model.addAttribute("serviceList", serviceList);

		return "manager/viewService";

	}

	@GetMapping("/updateService")
	public String updateService(Model model, @RequestParam(name = "id") int id) throws Exception {

		ServiceEntity opt_Service = serviceService.findById(id);
		if (opt_Service != null) {
			model.addAttribute("service", opt_Service);

			return "manager/updateService";
		} else {
			return "error";
		}

	}

	@PostMapping("/doUpdateService")
	public String doUpdateService(@Valid @ModelAttribute(name = "service") ServiceEntity service, BindingResult rs,
			Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<ServiceEntity> serviceList = serviceService.findAll();
			model.addAttribute("serviceList", serviceList);
			return "manager/updateCategory";

		} else {
			service.setImageEntities(imageService.uploadImageService(service.getImages(), servletRequest, service));
		}

		serviceService.save(service);

		List<ServiceEntity> serviceList = serviceService.findAll();
		model.addAttribute("serviceList", serviceList);

		return "manager/viewService";
	}

	@GetMapping("/deleteImageService/{id}/{serviceId}")
	public String deleteImageService(Model model, @PathVariable(name = "id") int id,
			@PathVariable(name = "serviceId") int serviceId) {

		imageService.deleteImgService(serviceId, id);

		return "redirect:/updateService?id=" + serviceId;
	}

	// Promotion
	@GetMapping("/viewPromotion")
	public String viewPromotion(Model model) {

		List<PromotionEntity> promotionList = promotionService.findAll();
		model.addAttribute("promotionList", promotionList);

		return "manager/viewPromotion";
	}

	@GetMapping("/addPromotion")
	public String addPromotion(Model model) {

		model.addAttribute("promotion", new PromotionEntity());

		return "manager/addPromotion";
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

			return "manager/viewPromotion";
		}
	}

	@GetMapping("/updatePromotion")
	public String updatePromotion(Model model, @RequestParam(name = "id") int id) throws Exception {

		Optional<PromotionEntity> opt_Promotion = promotionService.findById(id);
		if (opt_Promotion != null) {
			model.addAttribute("promotion", opt_Promotion);

			return "manager/updatePromotion";
		} else {
			return "error";
		}

	}

	@PostMapping("/doUpdatePromotion")
	public String doUpdatePromotion(@Valid @ModelAttribute(name = "promotion") PromotionEntity promotion,
			BindingResult rs, Model model, HttpServletRequest servletRequest) {

		if (rs.hasErrors()) {
			List<PromotionEntity> promotionList = promotionService.findAll();
			model.addAttribute("promotionList", promotionList);
			return "admin/updatePromotion";

		} else {
			promotion.setImageEntities(
					imageService.uploadImagePromotion(promotion.getImages(), servletRequest, promotion));
		}

		promotionService.save(promotion);

		List<PromotionEntity> promotionList = promotionService.findAll();
		model.addAttribute("promotionList", promotionList);

		return "manager/viewPromotion";
	}

	@GetMapping("/deleteImagePromotion/{id}/{promotionId}")
	public String deleteImagePromotion(Model model, @PathVariable(name = "id") int id,
			@PathVariable(name = "promotionId") int promotionId) {

		imageService.deleteImgPromotion(promotionId, id);

		return "redirect:/updatePromotion?id=" + promotionId;
	}

	@GetMapping("/deletePromotion")
	public String deletePromotion(Model model, @RequestParam(name = "id") int id) {

		promotionService.deleteById(id);

		List<PromotionEntity> promotionList = promotionService.findAll();
		model.addAttribute("promotionList", promotionList);

		return "manager/viewPromotion";

	}

	// Booking
	@GetMapping("/viewBooking")
	public String viewBooking(Model model) {

		List<BookingEntity> bookingList = bookingService.findAll();
		model.addAttribute("bookingList", bookingList);

		return "manager/viewBooking";
	}

	@GetMapping("/bookingDetail")
	public String bookingDetail(Model model, @RequestParam(name = "id") int id) throws Exception {

		BookingEntity booking = bookingService.findById(id);

		List<BookingDetailEntity> bookingDetailList = bookingDetailsService.findByBookingId(id);

		if (booking != null) {

			model.addAttribute("bookingDetailList", bookingDetailList);
			model.addAttribute("booking", booking);

			return "manager/bookingDetail";
		} else {
			return "error";
		}

	}

	@GetMapping("/ServiceBooking")
	public String ServiceBooking(Model model, @RequestParam(name = "id") int id) throws Exception {

		BookingDetailEntity bookingDetail = bookingDetailsService.findbyId(id);

		List<ServiceBookingEntity> serviceBookingList = serviceBookingService.findByBookingDetailId(id);
		if (bookingDetail != null) {
			model.addAttribute("serviceBookingList", serviceBookingList);
			model.addAttribute("bookingDetail", bookingDetail);
			model.addAttribute("serviceBooking", new ServiceBookingEntity());
			model.addAttribute("serviceList", serviceService.findAll());
			return "manager/addServiceBooking";
		} else {
			return "error";
		}

	}

	@PostMapping("/doAddServiceBooking")
	public String addServicebooking(Model model, @ModelAttribute(name = "serviceBooking") ServiceBookingEntity serviceBooking) {
		
		int total = (int) (serviceBooking.getQuantity() * serviceBooking.getService().getPrice());
		
		serviceBooking.setPrice(total);
		serviceBooking.setServiceBookingDate(LocalDate.now());
		serviceBookingService.save(serviceBooking);
		
		return "manager/addServiceBooking";
	}
	

	@GetMapping("/deleteServiceInServiceBooking")
	public String deleteServiceInServiceBooking(Model model, @RequestParam(name = "id") int id,
			@RequestParam(name = "bookingDetailId") int bookingDetailId) {

		bookingDetailsService.deleteServiceBooking(id, bookingDetailId);

		return "redirect:/ServiceBooking?id=" + bookingDetailId;

	}

}

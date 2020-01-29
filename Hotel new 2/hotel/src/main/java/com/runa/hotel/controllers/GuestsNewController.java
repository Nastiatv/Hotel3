//package com.runa.hotel.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.runa.hotel.api.dto.GuestDto;
//import com.runa.hotel.api.service.IGuestService;
//
//@RestController
//@RequestMapping("/guests")
//public class GuestsNewController {
//
//	@Autowired
//		IGuestService guestService;
//
//		@GetMapping
//		public ModelAndView getAllGuests() {
//			ModelAndView modelAndView=new ModelAndView();
//			List<GuestDto> guests=guestService.getAllGuests();
//			modelAndView.setViewName("guests");
//			modelAndView.addObject("guestList", guests);
//			return modelAndView;
//		}
//		
//		
//		
//		
//		
//}
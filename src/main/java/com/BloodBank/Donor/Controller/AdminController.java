package com.BloodBank.Donor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BloodBank.Donor.model.AdminRegisterModel;
import com.BloodBank.Donor.services.AdminLoginService;

import jakarta.validation.Valid;



	
@Controller
public class AdminController {  

		
@Autowired
private AdminLoginService adminLoginService;
		
		@GetMapping("/adminLog")
		public String AdminLogin(@Valid Model model) {
			System.out.println("inside admin login");    
			model.addAttribute("admin", new AdminRegisterModel());
			return "adminLogin";
		}
		
		
		@PostMapping("/adminLog")
		public String adminLoginSubmit(@Valid @ModelAttribute AdminRegisterModel adminRegisterModel, BindingResult bindingResult) {
			System.out.println("Inside Post Login for Admin");
			boolean success = adminLoginService.adminLogin(adminRegisterModel);
			System.out.println(success);
			String result="";
			if(bindingResult.hasErrors()) {
				System.out.println(bindingResult);
				result="adminLogin";
			}else if(success) {
				result="redirect:/admin/home";
			}else {
				result = "redirect:/adminLog";

			}
			return result;
		}
}		


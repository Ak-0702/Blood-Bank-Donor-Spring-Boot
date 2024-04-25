package com.BloodBank.Donor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BloodBank.Donor.model.UserLoginModel;
import com.BloodBank.Donor.model.UserRegisterModel;
import com.BloodBank.Donor.services.UserLoginService;

import jakarta.validation.Valid;



@Controller
public class UserController {
		
		@Autowired
		private UserLoginService userLoginService;
		
		@GetMapping("/userLog")
		public String UserLogin(@Valid Model model) {
			System.out.println("inside login");
			model.addAttribute("user", new UserLoginModel());
			return "UserLogin";
		}
		
		@PostMapping("/userLog")
		public String loginSubmit(@Valid @ModelAttribute UserRegisterModel userRegisterModel, BindingResult bindingResult) {
			System.out.println("inside Post login");
			boolean success = userLoginService.userLogin(userRegisterModel);
			System.out.println(success);
			String res = "";
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult);
				res = "userLogin";
			}else if(success){
				res = "redirect:/user/home";
			}else {
				res = "redirect:/userLog";
			}
			return res;
		}
}

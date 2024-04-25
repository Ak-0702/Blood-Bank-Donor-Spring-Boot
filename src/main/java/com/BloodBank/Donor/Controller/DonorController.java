package com.BloodBank.Donor.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BloodBank.Donor.Repository.UserRepository;
import com.BloodBank.Donor.model.UserRegisterModel;
import com.BloodBank.Donor.services.DonationService;

@Controller
public class DonorController {

	@Autowired
	private DonationService donationService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/nextDonationDate")
	public String showForm(Model model) {
		UserRegisterModel userRegisterModel = new UserRegisterModel();
		model.addAttribute("Register", userRegisterModel);
		return "Donation";
	}

	@PostMapping("/nextDonationDate")
	public String submitForm(@RequestParam("usermobile") String usermobile,
			@ModelAttribute("Register") UserRegisterModel userRegisterModel, Model model) {

		userRegisterModel = userRepository.findByusermobile(usermobile);
		if (userRegisterModel != null) {
			String checkStatus = donationService.checkDonation(userRegisterModel.getUsermobile());

			model.addAttribute("donationStatus", checkStatus);
			return "Donation";
		} else {
			model.addAttribute("message", "Please enter a valid Mobile Number");

			return "Donationerror";
		}
	}
}

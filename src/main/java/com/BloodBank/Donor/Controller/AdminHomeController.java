package com.BloodBank.Donor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.BloodBank.Donor.Repository.BloodGroupRepository;

@Controller
public class AdminHomeController {
	
	@Autowired
	private BloodGroupRepository bloodRepo;

	@GetMapping("/admin/home")
    public String AdminHomePage() {
        return "AdminHome";
    }
	
	@GetMapping("/viewBloodStock")
	public String DisplayStock(Model model) {
		model.addAttribute("viewstock", bloodRepo.findAll());
		return "DisplayStocks";
	}
}



package com.BloodBank.Donor.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BloodBank.Donor.Repository.UserRepository;
import com.BloodBank.Donor.model.UserRegisterModel;
import com.BloodBank.Donor.services.AdminLoginService;



@Controller
public class AdminCRUDController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminLoginService adminLoginService;
		
	@GetMapping("/DisplayDonorDetails")
    public String displayDonorDetails(Model model) {
        List<UserRegisterModel> donorList = userRepository.findAll();
        model.addAttribute("donors", donorList);
        return "DisplayDonorDetails";
	}
	
	@GetMapping("/updateDonorDetails")
	public String Updatedonordetails(Model model) {
		System.out.println("aarthi");
		model.addAttribute("updatedetails", userRepository.findAll());
		return "UpdateDonor";
	}
	
	
	  @PostMapping("/updateDonorDetails")
	  public String Updatedonordetails(UserRegisterModel userRegisterModel) {
	  System.out.println("Sas");
	  userRepository.save(userRegisterModel);
	  return "UpdateDonorDetails";
	 }
	
	@GetMapping("/updateDonor/{id}")
	public String Updatedonor(@PathVariable("id") Long id,Model model) {
		System.out.println("Sanjay Inside Update");
		UserRegisterModel registerModel = userRepository.findById(id).get();
		model.addAttribute("updatedonor",registerModel);
		return "UpdateDonorDetails";	
	}
	

	@PostMapping("/updatedonordetails")
	public String SaveUpdatedDonor(UserRegisterModel userRegisterModel) {
		userRepository.save(userRegisterModel);
		
		return "redirect:/updateDonorDetails";
	}
	
	
	@GetMapping("/deleteDonor/{id}")
	public String deleteDonor(@PathVariable("id") Long id) {
	    userRepository.deleteById(id);
	    return "redirect:/updateDonorDetails";
	}

}
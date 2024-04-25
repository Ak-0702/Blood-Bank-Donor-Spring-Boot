	package com.BloodBank.Donor.Controller;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	 
	import com.BloodBank.Donor.Repository.AdminRepository;
	import com.BloodBank.Donor.Repository.UserRepository;
	import com.BloodBank.Donor.model.AdminRegisterModel;
	import com.BloodBank.Donor.model.UserRegisterModel;
	 
	 
	 
	
	@Controller
	public class HomeController {
	 
		@Autowired
		private UserRepository userRepo;
		
		@Autowired
		private AdminRepository adminRepo;
	 
	    @GetMapping("/")
	    public String homePage() {
	        return "home";
	    }
	 
	    @GetMapping("/adminRegister")
	    public String adminRegistrationPage(Model model) {
	    	System.out.println("insiddfyghj");
	    	AdminRegisterModel adminModel = new AdminRegisterModel();
	    	model.addAttribute("adminModel", adminModel);
	        return "adminRegister";
	    }
	    @PostMapping("/adminRegister")
	    public String saveAdmins(AdminRegisterModel adminRegisterModel) {
	    	System.out.println(adminRegisterModel);
	    	adminRepo.save(adminRegisterModel);
	    	return "redirect:/adminLog";
	    }
	 
	    @GetMapping("/adminLogin")
	    public String adminLoginPage() {
	        return "adminLog";
	    }
	 
	    @GetMapping("/userRegistration")
	    public String userRegistrationPage(Model model) {
	    	System.out.println("ggggggg");
	       UserRegisterModel userModel = new UserRegisterModel();
	        model.addAttribute("userModel", userModel);
	        return "UserRegistration";
	    }
	 
	   
	    @PostMapping("/userLogin")
	    public String saveUsers(UserRegisterModel userModel) {
	    	System.out.println(userModel);
	        userRepo.save(userModel);
	        return "redirect:/userLog";
	    }
	  
	    @GetMapping("/contact")
	    public String contactPage() {
	        return "Contact";
	    }
	    
	    
	   
	    
}
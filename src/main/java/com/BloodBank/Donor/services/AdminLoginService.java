package com.BloodBank.Donor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodBank.Donor.Repository.AdminRepository;
import com.BloodBank.Donor.model.AdminRegisterModel;

@Service
public class AdminLoginService {

	
	
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean adminLogin(AdminRegisterModel adminRegisterModel) {//admin obj
		AdminRegisterModel adminReg = adminRepository.findByAdminname(adminRegisterModel.getAdminname());
		if(adminReg != null && adminReg.getPassword() != null && adminReg.getPassword().equals(adminRegisterModel.getPassword())) {
			return true;
		}else {
			return false;
		} 
	}

	public void deleteDonor(Long user_id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(user_id);
	}
}

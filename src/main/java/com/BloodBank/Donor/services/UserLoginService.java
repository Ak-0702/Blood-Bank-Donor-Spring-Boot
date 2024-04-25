package com.BloodBank.Donor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodBank.Donor.Repository.UserRepository;
import com.BloodBank.Donor.model.UserRegisterModel;




	@Service
	public class UserLoginService {
		@Autowired
		private UserRepository userRepository;
		
		public boolean userLogin(UserRegisterModel userRegisterModel) {
			UserRegisterModel userReg = userRepository.findByUsername(userRegisterModel.getUsername());
			if(userReg != null && userReg.getPassword().equals(userRegisterModel.getPassword())){
				return true;
			} else {
				return false;
			}
		}
}

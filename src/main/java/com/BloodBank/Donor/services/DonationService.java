package com.BloodBank.Donor.services;


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodBank.Donor.Repository.UserRepository;
import com.BloodBank.Donor.model.UserRegisterModel;

@Service
public class DonationService {

	@Autowired
	private UserRepository userRepository;

	public String checkDonation(String usermobile) {
		UserRegisterModel userRegister = userRepository.findByusermobile(usermobile);
		long diffInMillies = Math.abs(new Date().getTime() - userRegister.getLastDonationDate().getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if (diff < 180) { 
			return "you can't able to donate because your lastdonation is less than six months";
		} else {
			return "you can donate now";
		}
	}

}

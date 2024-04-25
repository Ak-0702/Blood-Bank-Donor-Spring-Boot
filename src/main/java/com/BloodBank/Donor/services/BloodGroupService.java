package com.BloodBank.Donor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodBank.Donor.Repository.BloodGroupRepository;
import com.BloodBank.Donor.model.BloodGroupModel;

@Service
public class BloodGroupService {

	 @Autowired
	    private BloodGroupRepository bloodGroupRepository;

	 public void donateBlood(String type, int units) {
	        type = type.toUpperCase(); 
	        BloodGroupModel bloodGroup = bloodGroupRepository.findByType(type)
	            .orElse(new BloodGroupModel(type));
	        bloodGroup.setUnits(bloodGroup.getUnits() + units);
	        bloodGroupRepository.save(bloodGroup);
	    }
}

package com.BloodBank.Donor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BloodBank.Donor.model.UserRegisterModel;



public interface UserRepository extends JpaRepository<UserRegisterModel, Long>{

	UserRegisterModel findByUsername(String username);

	UserRegisterModel findByusermobile(String usermobile);

}

package com.BloodBank.Donor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BloodBank.Donor.model.AdminRegisterModel;

public interface AdminRepository extends JpaRepository<AdminRegisterModel, Long> {

	AdminRegisterModel findByAdminname(String adminname);

	

}
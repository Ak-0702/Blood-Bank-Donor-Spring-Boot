package com.BloodBank.Donor.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BloodBank.Donor.model.BloodGroupModel;

public interface BloodGroupRepository extends JpaRepository<BloodGroupModel, Long>{
	Optional<BloodGroupModel> findByType(String type);
}

package com.BloodBank.Donor.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BloodBank.Donor.model.SupplyModel;

@Repository
	public interface SupplyRepository extends JpaRepository<SupplyModel, Long> {
	    Optional<SupplyModel> findByType(String type);
	}



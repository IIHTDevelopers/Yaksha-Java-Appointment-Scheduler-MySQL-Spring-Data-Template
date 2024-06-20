package com.appointment.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	// write your code for method to find list of doctors by their specialty, ordered by name in ascending order

	
	// write your code for method to find all doctors ordered by name in ascending order
	// and it must return data in pages
	
}

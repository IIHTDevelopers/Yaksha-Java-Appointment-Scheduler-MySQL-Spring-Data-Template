package com.appointment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	// write your logic here to find list of doctors by speciality

	// write your logic here to find list of schedules by doctor name and speciality

	// write your logic here to find schedule by doctor id

	// write your logic here to find all doctor ordered by their speciality
}

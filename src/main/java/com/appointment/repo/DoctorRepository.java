package com.appointment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appointment.entity.Doctor;
import com.appointment.entity.Schedule;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	List<Doctor> findBySpecialty(String specialty);

	@Query("SELECT s FROM Schedule s WHERE s.doctor.name = :doctorName AND s.doctor.specialty = :specialty")
	List<Schedule> findSchedulesByDoctorNameAndSpecialty(String doctorName, String specialty);

	@Query("SELECT s FROM Schedule s WHERE s.doctor.id = :doctorId")
	List<Schedule> findSchedulesByDoctorId(Long doctorId);

	List<Doctor> findAllByOrderBySpecialtyAsc();
}

package com.appointment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appointment.dto.DoctorDTO;
import com.appointment.entity.Schedule;
import com.appointment.exception.NotFoundException;

public interface DoctorService {

	DoctorDTO createDoctor(DoctorDTO doctorDTO);

	DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) throws NotFoundException;

	List<DoctorDTO> getAllDoctors();

	DoctorDTO getDoctorById(Long id) throws NotFoundException;

	boolean deleteDoctor(Long id) throws NotFoundException;

	List<DoctorDTO> findDoctorsBySpecialty(String specialty);

	List<Schedule> findSchedulesByDoctorNameAndSpecialty(String doctorName, String specialty);

	List<Schedule> findSchedulesByDoctorId(Long doctorId);

	List<DoctorDTO> findAllByOrderBySpecialtyAsc();
}

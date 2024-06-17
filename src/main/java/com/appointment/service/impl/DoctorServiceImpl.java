package com.appointment.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appointment.dto.DoctorDTO;
import com.appointment.exception.NotFoundException;
import com.appointment.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Override
	public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
		// write your logic here
		return null;
	}

	@Override
	public DoctorDTO updateDoctor(Long doctorId, DoctorDTO doctorDTO) throws NotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public DoctorDTO getDoctorById(Long doctorId) throws NotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public boolean deleteDoctor(Long doctorId) throws NotFoundException {
		// write your logic here
		return false;
	}

	@Override
	public Page<DoctorDTO> getAllDoctors(Pageable pageable) {
		// write your logic here
		return null;
	}

	@Override
	public List<DoctorDTO> findDoctorsBySpecialty(String specialty) {
		// write your logic here
		return null;
	}

}

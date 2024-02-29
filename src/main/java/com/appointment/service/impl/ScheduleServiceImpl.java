package com.appointment.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appointment.dto.ScheduleDTO;
import com.appointment.exception.NotFoundException;
import com.appointment.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Override
	public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
		// write your logic here
		return null;
	}

	@Override
	public ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO) throws NotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public List<ScheduleDTO> getAllSchedules() {
		// write your logic here
		return null;
	}

	@Override
	public ScheduleDTO getScheduleById(Long id) throws NotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public boolean deleteSchedule(Long id) throws NotFoundException {
		// write your logic here
		return false;
	}

	@Override
	public List<ScheduleDTO> getDoctorScheduleByDay(Long doctorId, LocalDate day) {
		// write your logic here
		return null;
	}
}

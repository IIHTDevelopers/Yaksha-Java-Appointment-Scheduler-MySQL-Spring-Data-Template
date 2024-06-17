package com.appointment.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public ScheduleDTO updateSchedule(Long scheduleId, ScheduleDTO scheduleDTO) throws NotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public ScheduleDTO getScheduleById(Long scheduleId) throws NotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public boolean deleteSchedule(Long scheduleId) throws NotFoundException {
		// write your logic here
		return false;
	}

	@Override
	public Page<ScheduleDTO> getAllSchedules(Pageable pageable) {
		// write your logic here
		return null;
	}

	@Override
	public List<ScheduleDTO> getDoctorScheduleByDay(Long doctorId, String day) {
		// write your logic here
		return null;
	}

	@Override
	public List<ScheduleDTO> getDoctorAppointments(Long doctorId, String day) {
		// write your logic here
		return null;
	}
}

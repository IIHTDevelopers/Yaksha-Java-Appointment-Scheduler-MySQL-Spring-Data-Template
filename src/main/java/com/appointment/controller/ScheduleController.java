package com.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.dto.ScheduleDTO;
import com.appointment.exception.NotFoundException;
import com.appointment.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

	private final ScheduleService scheduleService;

	@Autowired
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@PostMapping("/appointment")
	public ResponseEntity<ScheduleDTO> scheduleAppointment(@Validated @RequestBody ScheduleDTO scheduleDTO) {
			// write your logic here
    		return null;
	}	

	@PutMapping("/appointment/{id}")
	public ResponseEntity<ScheduleDTO> updateAppointment(@PathVariable Long id,
			@Validated @RequestBody ScheduleDTO scheduleDTO) {
			// write your logic here
			return null;

	}

	@GetMapping("/appointment/{id}")
	public ResponseEntity<ScheduleDTO> getAppointmentById(@PathVariable Long id) {
			// write your logic here
			return null;

	}

	@GetMapping("/doctor/{id}/{day}")
	public ResponseEntity<List<ScheduleDTO>> getDoctorScheduleByDay(@PathVariable Long id, @PathVariable String day) {
			// write your logic here
			return null;
	}
}

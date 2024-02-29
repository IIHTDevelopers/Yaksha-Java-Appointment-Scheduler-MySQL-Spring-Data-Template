package com.appointment.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.appointment.dto.DoctorDTO;
import com.appointment.dto.ScheduleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MasterData {

	public static DoctorDTO getDoctorDTO() {
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(1L);
		doctorDTO.setName("Dr. Smith");
		doctorDTO.setHospitalName("City Hospital");
		doctorDTO.setSpecialty("Pediatrics");
		doctorDTO.setDailyTime("08:00-17:00");
		return doctorDTO;
	}

	public static List<DoctorDTO> getDoctorDTOList() {
		List<DoctorDTO> doctorDTOList = new ArrayList<>();
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(1L);
		doctorDTO.setName("Dr. Smith");
		doctorDTO.setHospitalName("City Hospital");
		doctorDTO.setSpecialty("Pediatrics");
		doctorDTO.setDailyTime("08:00-17:00");
		doctorDTOList.add(doctorDTO);
		return doctorDTOList;
	}

	public static ScheduleDTO getScheduleDTO() {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setId(1L);
		scheduleDTO.setName("John Doe");
		scheduleDTO.setNameOfPatient("John Doe");
		scheduleDTO.setTime(LocalTime.parse("09:00"));
		LocalDate updatedDay = LocalDate.of(2023, 12, 25); // Example: December 25, 2023
		LocalTime updatedTime = LocalTime.of(15, 30); // Example: 3:30 PM
		scheduleDTO.setDay(updatedDay);
		scheduleDTO.setTimings("10:00 AM to 10:00 PM");
		DoctorDTO doctorDTO = getDoctorDTO();
		scheduleDTO.setDoctor(doctorDTO);
		return scheduleDTO;
	}

	public static List<ScheduleDTO> getScheduleDTOList() {
		List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setId(1L);
		scheduleDTO.setNameOfPatient("John Doe");
		scheduleDTO.setTime(LocalTime.parse("09:00"));
		DoctorDTO doctorDTO = getDoctorDTO();
		scheduleDTO.setDoctor(doctorDTO);
		scheduleDTOList.add(scheduleDTO);
		return scheduleDTOList;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String randomStringWithSize(int size) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < size; i++) {
			s.append("A");
		}
		return s.toString();
	}
}

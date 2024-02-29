package com.appointment.functional;

import static com.appointment.utils.MasterData.getScheduleDTO;
import static com.appointment.utils.TestUtils.businessTestFile;
import static com.appointment.utils.TestUtils.currentTest;
import static com.appointment.utils.TestUtils.testReport;
import static com.appointment.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.appointment.controller.ScheduleController;
import com.appointment.dto.DoctorDTO;
import com.appointment.dto.ScheduleDTO;
import com.appointment.entity.Doctor;
import com.appointment.entity.Schedule;
import com.appointment.exception.NotFoundException;
import com.appointment.repo.DoctorRepository;
import com.appointment.repo.ScheduleRepository;
import com.appointment.service.ScheduleService;
import com.appointment.utils.MasterData;

@WebMvcTest(ScheduleController.class)
@AutoConfigureMockMvc
public class ScheduleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ScheduleService scheduleService;

	@MockBean
	private ScheduleRepository scheduleRepository;

	@MockBean
	private DoctorRepository doctorRepository;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetAppointmentById() throws Exception {
		ScheduleDTO scheduleDTO = getScheduleDTO();
		when(this.scheduleService.getScheduleById(scheduleDTO.getId())).thenReturn(scheduleDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/schedules/appointment/" + scheduleDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(scheduleDTO)) ? "true"
						: "false"),
				businessTestFile);
	}

	@Test
	public void testUpdateSchedule() throws Exception {
		try {
			ScheduleDTO scheduleDTO = getScheduleDTO();
			when(this.scheduleService.updateSchedule(eq(scheduleDTO.getId()), any())).thenReturn(scheduleDTO);
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.put("/api/schedules/appointment/" + scheduleDTO.getId())
					.content(MasterData.asJsonString(scheduleDTO)).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			yakshaAssert(currentTest(),
					(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(scheduleDTO))
							? "true"
							: "false"),
					businessTestFile);
		} catch (Exception ex) {
			ex.printStackTrace();
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testUpdateSchedule_RollbackOnException() throws Exception {
		try {
			ScheduleDTO scheduleDTO = getInvalidScheduleDTO(); // Define an invalid schedule data
			when(scheduleService.updateSchedule(eq(scheduleDTO.getId()), any())).thenThrow(NotFoundException.class);
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.put("/api/schedules/appointment/" + scheduleDTO.getId())
					.content(MasterData.asJsonString(scheduleDTO)).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
			mockMvc.perform(requestBuilder);
			Schedule savedSchedule = scheduleRepository.findById(scheduleDTO.getId()).orElse(null);
			Doctor savedDoctor = doctorRepository.findById(scheduleDTO.getDoctor().getId()).orElse(null);
			yakshaAssert(currentTest(), savedSchedule == null && savedDoctor == null, businessTestFile);
		} catch (Exception ex) {
			ex.printStackTrace();
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	private ScheduleDTO getInvalidScheduleDTO() {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setId(1L); // Set the ID or use the appropriate ID for an existing schedule
		scheduleDTO.setName(null);
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(101L); // Doctor ID
		doctorDTO.setName("Updated Doctor Name");
		doctorDTO.setHospitalName("Updated Hospital");
		doctorDTO.setSpecialty("Updated Specialty");
		scheduleDTO.setDoctor(doctorDTO);
		LocalDate updatedDay = LocalDate.of(2023, 12, 25); // Example: December 25, 2023
		LocalTime updatedTime = LocalTime.of(15, 30); // Example: 3:30 PM
		scheduleDTO.setDay(updatedDay);
		scheduleDTO.setTime(updatedTime);
		return scheduleDTO;
	}
}

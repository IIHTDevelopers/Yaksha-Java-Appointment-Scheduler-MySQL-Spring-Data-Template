package com.appointment.entity;

import java.time.LocalTime;

public class Schedule {
	private Long id;

	private String name;

	private Doctor doctor;

	private String day;

	private LocalTime time;

	private String timings;

	private String nameOfPatient;

	public Schedule() {
		super();
	}

	public Schedule(Long id, String name, Doctor doctor, String day, LocalTime time, String timings,
			String nameOfPatient) {
		super();
		this.id = id;
		this.name = name;
		this.doctor = doctor;
		this.day = day;
		this.time = time;
		this.timings = timings;
		this.nameOfPatient = nameOfPatient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getNameOfPatient() {
		return nameOfPatient;
	}

	public void setNameOfPatient(String nameOfPatient) {
		this.nameOfPatient = nameOfPatient;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", name=" + name + ", doctor=" + doctor + ", day=" + day + ", time=" + time
				+ ", timings=" + timings + ", nameOfPatient=" + nameOfPatient + "]";
	}
}

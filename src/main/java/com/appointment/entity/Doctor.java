package com.appointment.entity;

public class Doctor {
	private Long id;

	private String name;

	private String hospitalName;

	private String specialty;

	private String dailyTime;

	public Doctor() {
		super();
	}

	public Doctor(Long id, String name, String hospitalName, String specialty, String dailyTime) {
		super();
		this.id = id;
		this.name = name;
		this.hospitalName = hospitalName;
		this.specialty = specialty;
		this.dailyTime = dailyTime;
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getDailyTime() {
		return dailyTime;
	}

	public void setDailyTime(String dailyTime) {
		this.dailyTime = dailyTime;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", hospitalName=" + hospitalName + ", specialty=" + specialty
				+ ", dailyTime=" + dailyTime + "]";
	}
}

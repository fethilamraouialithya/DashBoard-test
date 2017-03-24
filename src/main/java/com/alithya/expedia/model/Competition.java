package com.alithya.expedia.model;

import java.time.LocalDate;

public class Competition {
	private String name;
	private LocalDate year;
	
	public Competition(String name, LocalDate year) {
		super();
		this.name = name;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}
}

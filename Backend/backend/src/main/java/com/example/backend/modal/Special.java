package com.example.backend.modal;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Special {
	
	
	private String day;	
	private String hours;	
	private String title;
	private String description;
	
	
	
//	public Special(String day, String hours, String title, String description) {
//		this.day = day;
//		this.hours = hours;
//		this.title = title;
//		this.description = description;
//	}
	
//	public Special() {
//		// TODO Auto-generated constructor stub
//		
//	}

	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}

package com.example.task.data.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	public String title;
	private LocalDate date;
	public String task;
	
}
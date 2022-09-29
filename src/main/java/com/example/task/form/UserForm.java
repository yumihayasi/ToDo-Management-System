package com.example.task.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserForm {
public String title;
private LocalDate date;
public String task;
}

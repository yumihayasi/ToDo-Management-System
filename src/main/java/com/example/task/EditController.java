package com.example.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController{
	@GetMapping("/edit")
	public String edit() {
		return "edit";
	}
}
package com.example.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResistController {
	@GetMapping("/create")
	public String create() {
		return "create";
	}
}

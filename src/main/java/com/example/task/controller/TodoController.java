package com.example.task.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.task.data.repository.UserRepository;
import com.example.task.form.UserForm;


@Controller
public class TodoController {

	@Autowired
	private UserRepository userRepository;

@GetMapping("/main")
	
	public String getMain(Model model) {
	
	List<LocalDate> week1;
	LocalDate day1 = LocalDate.now().withDayOfMonth(1);
	for(int i = 1; i <= 7; i++) {
	day1 = day1.plusDays(i);
	week1.add(day1);
	}
	
	List<LocalDate> week2;
	LocalDate day2 = week1.get(6).plusDays(1);
	for(int i = 1; i <= 7; i++) {
		day2 = day2.plusDays(i);
	week2.add(day2);
	}
	
	List<LocalDate> week3;
	LocalDate day3 = week2.get(6).plusDays(1);
	for(int i = 1; i <= 7; i++) {
		day3 = day3.plusDays(i);
	week3.add(day3);
	}
	
	List<LocalDate> week4;
	LocalDate day4 = week3.get(6).plusDays(1);
	for(int i = 1; i <= 7; i++) {
		day4 = day4.plusDays(i);
	week4.add(day4);
	}
	
	List<LocalDate> week5;
	LocalDate day5 = week4.get(6).plusDays(1);
	for(int i = 1; i <= 7; i++) {
		day5 = day5.plusDays(i);
	week3.add(day5);
	}
		
	List<List<LocalDate>> month = new ArrayList<>();
	month.add(week1);
	month.add(week2);
	month.add(week3);
	month.add(week4);
	month.add(week5);

	

	@Query("select a from Tasks a where a.date between :from and :to and name = :name")
	List<Tasks> findByDateBetween(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to, @Param("name") String name);
	
	model.addAttribute("users", users);
	
		return "main";
}
	
@GetMapping("/create")
public String getNewUser(Model model) {
	UserForm userForm = new UserForm();
	model.addAttribute("userForm", userForm);
	// テンプレートは src/main/resources/templates/newuser.html とします。
	return "create";

}
@PostMapping("/create")
public String registerUser(UserForm userForm) {
	User user = new User();
	user.setTitle(userForm.getTitle());
	user.setDate(userForm.getDate());
	user.setTask(userForm.getTask());
	
	userRepository.save(user);
	// ユーザ一覧画面へリダイレクト
	return "redirect:/main";
}

}

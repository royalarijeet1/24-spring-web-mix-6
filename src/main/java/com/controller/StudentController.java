package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBoxCricketBean;
import com.util.Validators;

@Controller
public class StudentController {
	@GetMapping("/boxcricketregistration")
	public String boxRegistration() {
		return "BoxCricketReg";//jsp name 
	}
	
	@PostMapping("/savereg")
	public String saveRegistration(StudentBoxCricketBean studentBox,Model model) {
			//bean ->variable : jsp form 
		System.out.println(studentBox.getStudentName());
		System.out.println(studentBox.getPlayerType());
		System.out.println(studentBox.getFoodPreference());
		System.out.println(studentBox.getDrink());

		boolean isError = false;
	
		
		if (Validators.isBlank(studentBox.getStudentName())) {
			isError = true;
			model.addAttribute("studentNameError","Please Enter Student Name");
		}else if(Validators.isAlpha(studentBox.getStudentName())==false)
		{
			isError = true;
			model.addAttribute("studentNameError","Please Enter valid Student Name");
		}

		if (Validators.isBlank(studentBox.getPlayerType())) {
			isError = true;
			model.addAttribute("playerTypeError","Please Select PlayerType");
		}

		if (Validators.isBlank(studentBox.getFoodPreference())) {
			isError = true;
			model.addAttribute("foodPreferenceError","Please Selecct FoodPreference");
		}
		
		if (Validators.isBlank(studentBox.getDrink())) {
			isError = true;
			model.addAttribute("drinkPreferenceError","Please Select atleast one drink");
		}

		model.addAttribute("reg", studentBox);
		
		if (isError == true) {
			return "BoxCricketReg";
		} else {
			// how to send data to jsp from controller ?
			model.addAttribute("reg", studentBox);// data name -> data value
			return "RegDetail";
		}
	
	}
}

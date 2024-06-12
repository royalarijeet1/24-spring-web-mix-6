package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AddBean;



@Controller
public class AdditionController {
	@GetMapping("/add")
	public String add(){
		
		return "AddProgram";
	}
	
	@PostMapping("/saveresult")
	public String saveResult(AddBean addbean,Model model ){
		System.out.println("Number 1=> "+addbean.getN1());
		System.out.println("Number2=> "+addbean.getN2());
		model.addAttribute("add", addbean);
		return "Result";
	}
}

package com.controller.zomato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.bean.zomato.ZCustomerBean;
import com.dao.zomato.CustomerDao;


@Controller
public class ZController {
	
	@Autowired
	CustomerDao cDao;
	
	@GetMapping("/zsignup")
	public String signup() {
		return "ZcustSignup"; 
	}
	
	@PostMapping("/zsignup")
	public String signupPost(ZCustomerBean zBean) {
		//jsp form -> controller -> 
		
		//validation 
		//insert  	
		cDao.insertUser(zBean);
		
		return "ZcustLogin";
	}
}

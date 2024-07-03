package com.controller;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.bean.EUserBean;
import com.dao.EUserDao;
import com.service.FileUploadService;

@Controller
public class EcomSessionController {
	@Autowired
	EUserDao userDao;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@GetMapping("/")
	public String welcome() {
		return "EcomLogin";
	}
	
	@GetMapping("/esignup")
	public String signup() {
		return "EcomSignup"; 
	}

	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) {
		//jsp form -> controller -> 
		fileUploadService.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());
		//validation 
		userBean.setProfilePicPath(
				"images//profilepic//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
		//insert  	
		userDao.insertUser(userBean);
		
		return "EcomLogin";
	}
}

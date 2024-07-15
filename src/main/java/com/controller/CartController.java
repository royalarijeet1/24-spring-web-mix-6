package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ECartBean;
import com.bean.EUserBean;
import com.dao.CartDao;

import jakarta.servlet.http.HttpSession;



@Controller
public class CartController {
	@Autowired
	CartDao cartDao;

	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("productId") Integer productId, HttpSession session) {

		EUserBean userBean = (EUserBean) session.getAttribute("user");

		Integer userId = userBean.getUserId();

		ECartBean cartBean = new ECartBean();

		cartBean.setProductId(productId);
		cartBean.setUserId(userId);

		cartDao.addToCart(cartBean);

		return "redirect:/userproducts";// url
	}
}
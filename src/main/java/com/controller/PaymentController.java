package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EUserBean;
import com.bean.ProductCartBean;
import com.dao.CartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	@Autowired
	CartDao cartDao;
	@GetMapping("/checkout")
	public String checkout(HttpSession session,Model model) {
		EUserBean userBean = (EUserBean) session.getAttribute("user");
		Integer userId = userBean.getUserId();
		List<ProductCartBean> products = cartDao.myCart(userId);
		model.addAttribute("products",products);
		return "Checkout";
	}
}

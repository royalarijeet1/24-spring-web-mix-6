package com.dao.zomato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.zomato.ZCustomerBean;

@Repository
public class CustomerDao {
	
	@Autowired // instance eject
	JdbcTemplate stmt; // update() query()
	
	public void insertUser(ZCustomerBean zBean) {
		// query ->
		stmt.update("insert into customers(fname,email,password,contactno) values (?,?,?,?) ", zBean.getFname(),
				zBean.getEmail(), zBean.getPassword(),zBean.getContactno());

	}
}

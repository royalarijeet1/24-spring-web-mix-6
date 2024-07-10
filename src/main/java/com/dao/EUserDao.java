package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.bean.EUserBean;

@Repository
public class EUserDao {
	
	@Autowired // instance eject
	JdbcTemplate stmt; // update() query()

	public void insertUser(EUserBean userBean) {
		// query ->
		stmt.update("insert into users(firstName,email,password,profilePic) values (?,?,?,?) ", userBean.getFirstName(),
				userBean.getEmail(), userBean.getPassword(),userBean.getProfilePicPath());

	}
	
	public EUserBean authenticate(String email, String password) {
		// select * from users where email = ? and password = ?
		try {
			EUserBean userBean = stmt.queryForObject("select * from users where email = ? and password = ?",
					new BeanPropertyRowMapper<>(EUserBean.class), new Object[] { email, password });

			return userBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;// invalid
	}
}

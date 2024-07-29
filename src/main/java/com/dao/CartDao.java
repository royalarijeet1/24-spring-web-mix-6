package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ECartBean;
import com.bean.EProductBean;
import com.bean.ProductCartBean;

@Repository
public class CartDao {

	@Autowired
	JdbcTemplate stmt;

	public void addToCart(ECartBean cartBean) {
		ECartBean cart = null;
		try {
			cart = stmt.queryForObject("select * from cart where productId = ? and userId = ? ",
					new BeanPropertyRowMapper<>(ECartBean.class),
					new Object[] { cartBean.getProductId(), cartBean.getUserId() });
		} catch (Exception e) {

		}

		if (cart == null) {
			stmt.update("insert into cart (productId,userId,qty) values (?,?,?)", cartBean.getProductId(),
					cartBean.getUserId(), 1);
		} else {
			stmt.update("update cart set qty = ? where productId =? and userId = ? ", cart.getQty() + 1,
					cart.getProductId(), cart.getUserId());
		}
	}

	public List<ProductCartBean> myCart(Integer userId) {
		// select * from products join cart using (productId) where userId= 1;

		List<ProductCartBean> products = stmt.query("select c.*,p.price,p.productName,p.productImagePath from products p join cart c using (productId) where userId= ?",
				new BeanPropertyRowMapper<>(ProductCartBean.class), new Object[] { userId });
		return products;
	}

	public void deletecartbyId(Integer cartId) {
		// TODO Auto-generated method stub
		
		
		ECartBean cart=null;
		
		try {
			cart= stmt.queryForObject("select * from cart where cartId=?", 
					new BeanPropertyRowMapper<>(ECartBean.class), 
					new Object[] {cartId});
		}	
		catch(Exception e)
		{
			
		}
		

		if (cart.getQty() == 1) {
			stmt.update("delete from cart  where   cartId=?",cartId);
			
		} else {
			stmt.update("update cart set qty = ? where cartId=?", cart.getQty() - 1,cartId);
		}
	}


	// productId userId
}
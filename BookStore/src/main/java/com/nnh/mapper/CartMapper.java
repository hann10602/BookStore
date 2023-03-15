package com.nnh.mapper;

import java.sql.ResultSet;

import com.nnh.model.CartModel;

public class CartMapper implements RowMapper<CartModel>{

	@Override
	public CartModel rowMapper(ResultSet rs) {
		CartModel cm = new CartModel();
		
		try {
			cm.setId(rs.getLong("id"));
			cm.setQuantity(rs.getInt("quantity"));
			cm.setUserId(rs.getLong("user_id"));
			cm.setBookId(rs.getLong("book_id"));
			
			return cm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

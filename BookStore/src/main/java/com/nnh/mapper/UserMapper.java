package com.nnh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nnh.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel rowMapper(ResultSet rs) {
		UserModel um = new UserModel();
		
		try {
			um.setId(rs.getLong("id"));
			um.setUsername(rs.getString("username"));
			um.setPassword(rs.getString("password"));
			um.setFullname(rs.getString("fullname"));
			um.setRoleId(rs.getLong("role_id"));
			
			return um;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

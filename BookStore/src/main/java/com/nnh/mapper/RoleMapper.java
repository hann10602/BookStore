package com.nnh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nnh.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>{

	@Override
	public RoleModel rowMapper(ResultSet rs) {
		RoleModel rm = new RoleModel();
		
		try {
			rm.setCode(rs.getString("code"));
			rm.setName(rs.getString("name"));
			
			return rm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

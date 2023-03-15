package com.nnh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nnh.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel rowMapper(ResultSet rs) {
		CategoryModel cm = new CategoryModel();
		try {
			cm.setId(rs.getLong("id"));
			cm.setCode(rs.getString("code"));
			cm.setName(rs.getString("name"));
			
			return cm;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

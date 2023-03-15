package com.nnh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nnh.model.BookModel;

public class BookMapper implements RowMapper<BookModel>{

	@Override
	public BookModel rowMapper(ResultSet rs) {
		BookModel bm = new BookModel();
		
		try {
			bm.setId(rs.getLong("id"));
			bm.setTitle(rs.getString("title"));
			bm.setPrice(rs.getLong("price"));
			bm.setThumbnail(rs.getString("thumbnail"));
			bm.setDescription(rs.getString("description"));
			bm.setQuantity(rs.getLong("quantity"));
			bm.setCategoryId(rs.getLong("category_id"));
			if(rs.getString("modified_by") != null) {
				bm.setCreatedBy(rs.getString("modified_by"));
			}
			if(rs.getTimestamp("modified_date") != null) {
				bm.setCreatedDate(rs.getTimestamp("modified_date"));
			}
			
			return bm;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

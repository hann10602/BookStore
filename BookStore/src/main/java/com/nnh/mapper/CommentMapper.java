package com.nnh.mapper;

import java.sql.ResultSet;

import com.nnh.model.CommentModel;

public class CommentMapper implements RowMapper<CommentModel>{

	@Override
	public CommentModel rowMapper(ResultSet rs) {
		CommentModel cm = new CommentModel();
		try {
			cm.setId(rs.getLong("id"));
			cm.setContent(rs.getString("content"));
			cm.setUserId(rs.getLong("user_id"));
			cm.setBookId(rs.getLong("book_id"));
			cm.setCreatedDate(rs.getTimestamp("created_date"));
			
			return cm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

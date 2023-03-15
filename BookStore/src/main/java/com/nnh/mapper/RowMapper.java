package com.nnh.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T rowMapper(ResultSet rs);
}

package com.nnh.dao.itf;

import java.util.List;

import com.nnh.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> find(String sql, RowMapper<T> rowMapper, Object...objects);
	Long insert(String sql, Object...objects);
	void update(String sql, Object...objects);
	void delete(String sql, Object...objects);
}

package com.nnh.dao.imple;

import java.util.List;

import com.nnh.dao.itf.ICategoryDAO;
import com.nnh.mapper.CategoryMapper;
import com.nnh.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public CategoryModel findById(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> lcm = find(sql, new CategoryMapper(), id);
		return lcm.isEmpty() ? null : lcm.get(0);
	}

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return find(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> lcm = find(sql, new CategoryMapper(), code);
		return lcm.isEmpty() ? null : lcm.get(0);
	}
	
}

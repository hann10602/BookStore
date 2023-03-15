package com.nnh.dao.itf;

import java.util.List;

import com.nnh.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findById(Long id);
	CategoryModel findByCode(String code);
}

package com.nnh.service.imple;

import java.util.List;

import javax.inject.Inject;

import com.nnh.dao.itf.ICategoryDAO;
import com.nnh.model.CategoryModel;
import com.nnh.service.itf.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> find() {
		return categoryDAO.findAll();
	}

}

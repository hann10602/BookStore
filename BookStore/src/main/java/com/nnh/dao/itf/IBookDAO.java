package com.nnh.dao.itf;

import java.util.List;

import com.nnh.model.BookModel;

public interface IBookDAO extends GenericDAO<BookModel>{
	List<BookModel> findAll();
	List<BookModel> findByCategoryId(Long categoryId);
	List<BookModel> findByTitle(String title);
	List<BookModel> displayPage(Integer offset, Integer limit);
	List<BookModel> findById(Long id);
	Long save(BookModel bm);
	void delete(Long[] ids);
	
}

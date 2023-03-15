package com.nnh.service.itf;

import java.util.List;

import com.nnh.model.BookModel;

public interface IBookService {
	List<BookModel> find();
	List<BookModel> findByCategoryId(Long categoryId);
	List<BookModel> findByTitle(String title);
	List<BookModel> displayPages(Integer offset, Integer limit);
	BookModel findById(Long id);
	Long save(BookModel bm);
	void delete(Long[] ids);
}

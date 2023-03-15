package com.nnh.service.imple;

import java.util.List;

import javax.inject.Inject;

import com.nnh.dao.itf.IBookDAO;
import com.nnh.dao.itf.ICategoryDAO;
import com.nnh.model.BookModel;
import com.nnh.service.itf.IBookService;

public class BookService implements IBookService{
	@Inject
	private IBookDAO bookDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<BookModel> find() {
		return bookDAO.findAll();
	}
	
	@Override
	public List<BookModel> displayPages(Integer offset, Integer limit) {
		return bookDAO.displayPage(offset, limit);
	}

	@Override
	public BookModel findById(Long id) {
		List<BookModel> lbm = bookDAO.findById(id);
		BookModel bm = null;
		if(lbm != null) {
			bm = lbm.get(0);
		}
		bm.setCategoryCode(categoryDAO.findById(bm.getCategoryId()).getCode());
		
		return bm;
	}

	@Override
	public Long save(BookModel bm) {
		bm.setCategoryId(categoryDAO.findByCode(bm.getCategoryCode()).getId());
		return bookDAO.save(bm);
	}

	@Override
	public void delete(Long[] ids) {
		bookDAO.delete(ids);
	}

	@Override
	public List<BookModel> findByCategoryId(Long categoryId) {
		return bookDAO.findByCategoryId(categoryId);
	}

	@Override
	public List<BookModel> findByTitle(String title) {
		return bookDAO.findByTitle(title);
	}
	
}

package com.nnh.dao.imple;

import java.util.List;

import com.nnh.dao.itf.IBookDAO;
import com.nnh.mapper.BookMapper;
import com.nnh.model.BookModel;

public class BookDAO extends AbstractDAO<BookModel> implements IBookDAO{

	@Override
	public List<BookModel> findAll() {
		String sql = "SELECT * FROM book";
		
		return find(sql, new BookMapper());
	}

	@Override
	public List<BookModel> displayPage(Integer offset, Integer limit) {
		String sql = "SELECT * FROM book LIMIT ?, ?";
		return find(sql, new BookMapper(), offset, limit);
	}

	@Override
	public List<BookModel> findById(Long id) {
		String sql = "SELECT * FROM book WHERE id = ?";
		
		return find(sql, new BookMapper(), id);
	}

	@Override
	public Long save(BookModel bm) {
		if(bm.getId() != null) {
			String sql = "UPDATE book SET title=?, price=?, thumbnail=?, description=?, category_id=?, quantity=? WHERE id = ?";
			
			update(sql, bm.getTitle(), bm.getPrice(), bm.getThumbnail(), bm.getDescription(), bm.getCategoryId(), bm.getQuantity(), bm.getId());
			return bm.getId();
		}else {
			String sql = "INSERT INTO book(category_id, title, price, thumbnail, description, quantity) VALUES(?, ?, ?, ?, ?, ?)";
			
			return insert(sql, bm.getCategoryId(), bm.getTitle(), bm.getPrice(), bm.getThumbnail(), bm.getDescription(), bm.getQuantity());
		}
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "DELETE FROM book WHERE id = ?";
		
		for(Long id : ids) {
			delete(sql, id);
		}
	}

	@Override
	public List<BookModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM book WHERE category_id = ?";
		
		return find(sql, new BookMapper(), categoryId);
	}

	@Override
	public List<BookModel> findByTitle(String title) {
		String sql = "SELECT * FROM book WHERE title LIKE '%" + title + "%'";
		return find(sql, new BookMapper());
	}
	
	
	
}

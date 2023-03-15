package com.nnh.dao.imple;

import java.util.List;

import com.nnh.dao.itf.ICommentDAO;
import com.nnh.mapper.CommentMapper;
import com.nnh.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO{

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM comment WHERE id = ?";
		
		delete(sql, id);
	}

	@Override
	public Long save(CommentModel cm) {
		String sql = "INSERT INTO comment(content, user_id, book_id, created_date) VALUES(?, ?, ?, ?)";
		return insert(sql, cm.getContent(), cm.getUserId(), cm.getBookId(), cm.getCreatedDate());
	}

	@Override
	public List<CommentModel> findByBookId(Long id) {
		String sql = "SELECT * FROM comment WHERE book_id = ?";
		return find(sql, new CommentMapper(), id);
	}

}

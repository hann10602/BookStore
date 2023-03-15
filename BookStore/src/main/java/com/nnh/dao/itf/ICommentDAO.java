package com.nnh.dao.itf;

import java.util.List;

import com.nnh.model.CommentModel;

public interface ICommentDAO extends GenericDAO<CommentModel>{
	void delete(Long id);
	Long save(CommentModel cm);
	List<CommentModel> findByBookId(Long id);
}

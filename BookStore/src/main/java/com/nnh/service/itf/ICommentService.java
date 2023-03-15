package com.nnh.service.itf;

import java.util.List;

import com.nnh.model.CommentModel;

public interface ICommentService {
	void delete(Long id);
	Long save(CommentModel cm);
	List<CommentModel> findByBookId(Long id);
}

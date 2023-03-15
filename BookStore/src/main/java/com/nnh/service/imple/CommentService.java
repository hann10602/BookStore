package com.nnh.service.imple;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.nnh.dao.itf.ICommentDAO;
import com.nnh.dao.itf.IUserDAO;
import com.nnh.model.CommentModel;
import com.nnh.service.itf.ICommentService;

public class CommentService implements ICommentService{
	@Inject 
	private ICommentDAO commentDAO;
	
	@Inject 
	private IUserDAO userDAO;

	@Override
	public void delete(Long id) {
		commentDAO.delete(id);
	}

	@Override
	public Long save(CommentModel cm) {
		cm.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		return commentDAO.save(cm);
	}

	@Override
	public List<CommentModel> findByBookId(Long id) {
		List<CommentModel> lcm = commentDAO.findByBookId(id);
		for(CommentModel cm : lcm) {
			cm.setUsername(userDAO.findById(cm.getUserId()).getFullname());
		}
		return lcm;
	}

}

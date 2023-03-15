package com.nnh.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nnh.model.CommentModel;
import com.nnh.model.UserModel;
import com.nnh.service.itf.ICommentService;
import com.nnh.util.SessionUtil;

@WebServlet(urlPatterns = {"/comment"})
public class CommentController extends HttpServlet{
	@Inject
	private ICommentService commentService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contentStr = req.getParameter("content");
		String idStr = req.getParameter("id");
		UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
		if(user == null) {
			resp.sendRedirect("/BookStore/dang-nhap?active=login");
		} else {
			CommentModel cm = new CommentModel();
			cm.setContent(contentStr);
			cm.setBookId(Long.parseLong(idStr));
			cm.setUserId(user.getId());
			
			commentService.save(cm);
			
			resp.sendRedirect("/BookStore/trang-chu?id="+ idStr +"&active=sub-book");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String activeStr = req.getParameter("active");
		if(activeStr != null && activeStr.equals("delete")) {
			String commentIdStr = req.getParameter("id");
			String bookIdStr = req.getParameter("bookId");
			commentService.delete(Long.parseLong(commentIdStr));
			resp.sendRedirect("/BookStore/trang-chu?id="+ bookIdStr +"&active=sub-book");
		}
	}
}

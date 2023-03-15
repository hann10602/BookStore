package com.nnh.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnh.model.BookModel;
import com.nnh.model.UserModel;
import com.nnh.service.itf.IBookService;
import com.nnh.util.HttpUtil;
import com.nnh.util.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-book"})
public class API extends HttpServlet{
	@Inject
	private IBookService bookService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BookModel bm = HttpUtil.of(req.getReader()).toModel(BookModel.class);
		bm.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUsername());
		bm = bookService.findById(bookService.save(bm));
		om.writeValue(resp.getOutputStream(), bm);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BookModel bm = HttpUtil.of(req.getReader()).toModel(BookModel.class);
		bm.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUsername());
		bm = bookService.findById(bookService.save(bm));
		om.writeValue(resp.getOutputStream(), bm);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BookModel bm = HttpUtil.of(req.getReader()).toModel(BookModel.class);
		bookService.delete(bm.getIds());
		om.writeValue(resp.getOutputStream(), "");
	}
}

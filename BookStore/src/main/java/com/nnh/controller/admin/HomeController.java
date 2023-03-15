package com.nnh.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nnh.model.BookModel;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookModel bm = new BookModel();
		String typeStr = req.getParameter("type");
		String cPageStr = req.getParameter("cPage");
		String dPageStr = req.getParameter("dPage");
		String tPageStr = req.getParameter("tPage");
		String sortNameStr = req.getParameter("sortName");
		String sortByStr = req.getParameter("sortBy");
		if(typeStr != null) {
			bm.setType(typeStr);
		}if(cPageStr != null) {
			bm.setcPage(Integer.parseInt(cPageStr));
		}if(dPageStr != null) {
			bm.setdPage(Integer.parseInt(dPageStr));
		}if(tPageStr != null) {
			bm.settPages(Integer.parseInt(tPageStr));
		}if(sortNameStr != null) {
			bm.setSortName(sortNameStr);
		}if(sortByStr != null) {
			bm.setSortBy(sortByStr);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view/admin/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

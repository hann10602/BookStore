package com.nnh.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nnh.model.BookModel;
import com.nnh.service.itf.IBookService;
import com.nnh.service.itf.ICategoryService;

@WebServlet(urlPatterns = {"/admin-book-list"})
public class ListController extends HttpServlet{
	@Inject
	private IBookService bookService;
	
	@Inject
	private ICategoryService categoryService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ResourceBundle rb = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookModel bm = new BookModel();
		String view = "";
		String cPageStr = req.getParameter("cPage");
		String dPageStr = req.getParameter("dPage");
		String sortNameStr = req.getParameter("sortName");
		String sortByStr = req.getParameter("sortBy");
		String typeStr = req.getParameter("type");
		String priceStr = req.getParameter("price");
		String thumbnailStr = req.getParameter("thumbnail");
		String descriptionStr = req.getParameter("description");
		String quantityStr = req.getParameter("quantity");
		String messageStr = req.getParameter("message");
		String alertStr = req.getParameter("alert");
		if(cPageStr != null) {
			bm.setcPage(Integer.parseInt(cPageStr));
		}
		if(dPageStr != null) {
			bm.setdPage(Integer.parseInt(dPageStr));
		}
		if(sortNameStr != null) {
			bm.setSortName(sortNameStr);
		}
		if(sortByStr != null) {
			bm.setSortBy(sortByStr);
		}
		if(priceStr != null) {
			bm.setPrice(Long.parseLong(priceStr));
		}
		if(thumbnailStr != null) {
			bm.setThumbnail(thumbnailStr);
		}
		if(descriptionStr != null) {
			bm.setDescription(descriptionStr);
		}
		if(quantityStr != null) {
			bm.setQuantity(Long.parseLong(quantityStr));
		}
		if(messageStr != null) {
			if(rb.getString(messageStr) != null) {
				req.setAttribute("message", rb.getString(messageStr));
			}else {
				req.setAttribute("message", "");
			}
		}
		if(alertStr != null) {
			req.setAttribute("alert", alertStr);
		}
		if(typeStr != null) {
			if(typeStr.equals("list")) {
				int offset = (bm.getcPage() - 1) * bm.getdPage();
				bm.settPages((int) (Math.ceil((double) bookService.find().size() / bm.getdPage())));
				bm.setModelList(bookService.displayPages(offset, bm.getdPage()));
				view = "/view/admin/book/list.jsp";
			}else if(typeStr.equals("edit")) {
				String idStr = req.getParameter("id");
				req.setAttribute("categories", categoryService.find());
				if(idStr != null) {
					bm = bookService.findById(Long.parseLong(idStr));
					req.setAttribute("model", bm);
				}
				view = "/view/admin/book/edit.jsp";
			}
		}
		req.setAttribute("model", bm);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

package com.nnh.controller.web;

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
import com.nnh.model.UserModel;
import com.nnh.service.itf.IBookService;
import com.nnh.service.itf.ICartService;
import com.nnh.service.itf.ICategoryService;
import com.nnh.service.itf.ICommentService;
import com.nnh.service.itf.IUserService;
import com.nnh.util.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/dang-ky", "/thoat"})
public class HomeController extends HttpServlet{
	@Inject
	private IBookService bookService;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private ICartService cartService;
	
	@Inject 
	private ICommentService commentService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ResourceBundle rb = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String activeStr = req.getParameter("active");
		String messageStr = req.getParameter("message");
		String alertStr = req.getParameter("alert");
		if(messageStr != null && alertStr != null) {
			req.setAttribute("message", rb.getString(messageStr));
			req.setAttribute("alert", alertStr);
		}
		if(activeStr != null && activeStr.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
			rd.forward(req, resp);
		} else if(activeStr != null && activeStr.equals("logout")){
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect("/BookStore/trang-chu");
		} else if(activeStr != null && activeStr.equals("register")) {
			RequestDispatcher rd = req.getRequestDispatcher("/view/register.jsp");
			rd.forward(req, resp);
		} else if(activeStr != null && activeStr.equals("sub-book")) {
			String idStr = req.getParameter("id");
			if(idStr != null) {
				req.setAttribute("book", bookService.findById(Long.parseLong(idStr)));
				req.setAttribute("comments", commentService.findByBookId(Long.parseLong(idStr)));
			}
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/book/book-sub-page.jsp");
			rd.forward(req, resp);
		} else if(activeStr != null && activeStr.equals("cart")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if(user != null) {
				req.setAttribute("cartList", cartService.findCartByUser(user.getId()));
				req.setAttribute("totalBill", cartService.totalBill(cartService.findCartByUser(user.getId())));
				RequestDispatcher rd = req.getRequestDispatcher("/view/web/book/cart.jsp");
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("/BookStore/dang-nhap?active=login");
			}
		} else {
			String categoryIdStr = req.getParameter("category-id");
			String searchBookStr = req.getParameter("search-book");
			if(categoryIdStr != null) {
				req.setAttribute("book", bookService.findByCategoryId(Long.parseLong(categoryIdStr)));
			}else if(searchBookStr != null) {
				req.setAttribute("book", bookService.findByTitle(searchBookStr));
			} else {
				req.setAttribute("book", bookService.find());
			}
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String activeStr = req.getParameter("active");
		UserModel um = new UserModel();
		if(activeStr != null && activeStr.equals("login")) {
			String usernameStr = req.getParameter("username");
			String passwordStr = req.getParameter("password");
			if(usernameStr != null) {
				um.setUsername(usernameStr);
			}
			if(passwordStr != null) {
				um.setPassword(passwordStr);
			}
			um = userService.findOne(um);
			if(um != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", um);
				if(um.getRoleCode().equals("admin")) {
					resp.sendRedirect("/BookStore/admin-home");
				}else if(um.getRoleCode().equals("user")) {
					resp.sendRedirect("/BookStore/trang-chu");
				}
			} else {
				resp.sendRedirect("/BookStore/dang-nhap?active=login&message=un_pw_invalid&alert=danger");
			}
		}else if(activeStr != null && activeStr.equals("register")) {
			String fullnameStr = req.getParameter("fullname");
			String usernameStr = req.getParameter("username");
			String passwordStr = req.getParameter("password");
			String password2Str = req.getParameter("password2");
			if(fullnameStr != null) {
				um.setFullname(fullnameStr);
			}
			if(usernameStr != null) {
				um.setUsername(usernameStr);
			}
			if(passwordStr != null && password2Str != null) {
				um.setPassword(passwordStr);
			}
			if(usernameStr.contains(" ")) {
				resp.sendRedirect("/BookStore/dang-ky?active=register&message=username-contain-space&alert=danger");
			} else {
				if(password2Str.equals(passwordStr)) {
					if(passwordStr.length() < 6) {
						resp.sendRedirect("/BookStore/dang-ky?active=register&message=password-less-6-char&alert=danger");
					}else {
						if(userService.save(um) != null) {
							resp.sendRedirect("/BookStore/dang-ky?active=register&message=register-success&alert=success");
						}else {
							resp.sendRedirect("/BookStore/dang-ky?active=register&message=register-fail&alert=danger");
						}
					}
				} else {
					resp.sendRedirect("/BookStore/dang-ky?active=register&message=password-incorrect&alert=danger");
				}
			}
			
		}
	}
}

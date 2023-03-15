package com.nnh.controller.web;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nnh.model.CartModel;
import com.nnh.model.UserModel;
import com.nnh.service.itf.ICartService;
import com.nnh.util.SessionUtil;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet{
	@Inject
	private ICartService cartService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookIdStr = req.getParameter("bookId");
		String idStr = req.getParameter("id");
		String activeStr = req.getParameter("active");
		if(activeStr != null && activeStr.equals("delete")) {
			cartService.delete(Long.parseLong(idStr));
			resp.sendRedirect("/BookStore/trang-chu?active=cart");
		} else if(activeStr != null && activeStr.equals("update")) {
			String quantityStr = req.getParameter("quantity");
			CartModel cm = new CartModel();
			cm.setId(Long.parseLong(idStr));
			cm.setQuantity(Integer.parseInt(quantityStr));
			cartService.save(cm);
			resp.sendRedirect("/BookStore/trang-chu?active=cart");
		} else {
			if(bookIdStr != null) {
				UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
				if(user == null) {
					resp.sendRedirect("/BookStore/dang-nhap?active=login");
				} else {
					CartModel cart = new CartModel();
					cart.setUserId(user.getId());
					cart.setBookId(Long.parseLong(bookIdStr));
					if(cartService.findByUserAndBook(cart) != null) {
						cart = cartService.findByUserAndBook(cart);
						cart.setQuantity(cart.getQuantity() + 1);
						cartService.save(cart);
						resp.sendRedirect("/BookStore/trang-chu");
					}else {
						cartService.save(cart);
						resp.sendRedirect("/BookStore/trang-chu");
					}
				}
			}
		}
	}
}


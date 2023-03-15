package com.nnh.service.imple;

import java.util.List;

import javax.inject.Inject;

import com.nnh.dao.itf.ICartDAO;
import com.nnh.model.BookModel;
import com.nnh.model.CartModel;
import com.nnh.service.itf.IBookService;
import com.nnh.service.itf.ICartService;

public class CartService implements ICartService{
	@Inject
	private ICartDAO cartDAO;
	
	@Inject
	private IBookService bookDAO;

	@Override
	public Long save(CartModel cm) {
		return cartDAO.save(cm);
	}

	@Override
	public CartModel findByUserAndBook(CartModel cm) {
		List<CartModel> lcm = cartDAO.findByUserAndBook(cm);
		return lcm.isEmpty() ? null : lcm.get(0);
	}

	@Override
	public List<CartModel> findCartByUser(Long id) {
		List<CartModel> lcm = cartDAO.findCartByUser(id);
		for(CartModel cm : lcm) {
			BookModel bm = bookDAO.findById(cm.getBookId());
			cm.setBookTitle(bm.getTitle());
			cm.setBookPrice(bm.getPrice());
			cm.setBookThumbnail(bm.getThumbnail());
			cm.setTotalMoney(cm.getQuantity() * bm.getPrice());
			
		}
		
		
		return lcm;
	}

	@Override
	public Long totalBill(List<CartModel> lcm) {
		Long totalBill = 0L;
		for(CartModel cm : lcm) {
			totalBill += cm.getTotalMoney();
		}
		
		return totalBill;
	}

	@Override
	public void delete(Long id) {
		cartDAO.delete(id);
	}

}

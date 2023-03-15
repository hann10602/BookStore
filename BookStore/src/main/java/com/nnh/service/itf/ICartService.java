package com.nnh.service.itf;

import java.util.List;

import com.nnh.model.CartModel;

public interface ICartService {
	Long save(CartModel cm);
	CartModel findByUserAndBook(CartModel cm);
	List<CartModel> findCartByUser(Long id);
	Long totalBill(List<CartModel> lcm);
	void delete(Long id);
}

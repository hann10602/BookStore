package com.nnh.dao.itf;

import java.util.List;

import com.nnh.model.CartModel;

public interface ICartDAO extends GenericDAO<CartModel>{
	Long save(CartModel cm);
	List<CartModel> findByUserAndBook(CartModel cm);
	List<CartModel> findCartByUser(Long id);
	void delete(Long id);
}

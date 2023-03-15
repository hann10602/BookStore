package com.nnh.dao.imple;

import java.util.List;

import com.nnh.dao.itf.ICartDAO;
import com.nnh.mapper.CartMapper;
import com.nnh.model.CartModel;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO{

	@Override
	public Long save(CartModel cm) {
		if(cm.getId() != null) {
			String sql = "UPDATE cart SET quantity = ? WHERE id = ?";
			
			update(sql, cm.getQuantity(), cm.getId());;
			return cm.getId();
		}else {
			String sql = "INSERT INTO cart(quantity, user_id, book_id) VALUES(1, ?, ?)";
			
			return insert(sql, cm.getUserId(), cm.getBookId());
		}
	}

	@Override
	public List<CartModel> findByUserAndBook(CartModel cm) {
		String sql = "SELECT * FROM cart WHERE user_id = ? AND book_id = ?";
		return find(sql, new CartMapper(), cm.getUserId(), cm.getBookId());
	}

	@Override
	public List<CartModel> findCartByUser(Long id) {
		String sql = "SELECT * FROM cart WHERE user_id = ?";
		return find(sql, new CartMapper(), id);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM cart WHERE id = ?";
		delete(sql, id);
	}


}

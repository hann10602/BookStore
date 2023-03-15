package com.nnh.dao.imple;

import java.util.List;

import com.nnh.dao.itf.IUserDAO;
import com.nnh.mapper.UserMapper;
import com.nnh.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findOne(UserModel um) {
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		List<UserModel> lum = find(sql, new UserMapper(), um.getUsername(), um.getPassword());
		return lum.isEmpty() ? null : lum.get(0);
	}

	@Override
	public Long save(UserModel um) {
		String sql = "INSERT INTO user(username, password, fullname, role_id, status) VALUES(?, ?, ?, ?, ?)";
		return insert(sql, um.getUsername(), um.getPassword(), um.getFullname(), um.getRoleId(), um.getStatus());
	}

	@Override
	public UserModel findById(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> lum = find(sql, new UserMapper(), id);
		
		return lum.isEmpty() ? null : lum.get(0);
	}

}

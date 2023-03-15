package com.nnh.service.imple;

import javax.inject.Inject;

import com.nnh.dao.itf.IRoleDAO;
import com.nnh.dao.itf.IUserDAO;
import com.nnh.model.UserModel;
import com.nnh.service.itf.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;
	
	@Inject IRoleDAO roleDAO;
	
	@Override
	public UserModel findOne(UserModel um) {
		UserModel newUm = userDAO.findOne(um);
		if(newUm != null) {
			newUm.setRoleCode(roleDAO.findById(newUm.getRoleId()).getCode());
		}
		return newUm;
	}

	@Override
	public Long save(UserModel um) {
		um.setRoleId(2L);
		um.setStatus(1);
		return userDAO.save(um);
	}
}

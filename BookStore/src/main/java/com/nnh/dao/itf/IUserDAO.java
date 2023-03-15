package com.nnh.dao.itf;


import com.nnh.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel findOne(UserModel um);
	Long save(UserModel um);
	UserModel findById(Long id);
}

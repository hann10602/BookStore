package com.nnh.service.itf;

import com.nnh.model.UserModel;

public interface IUserService {
	UserModel findOne(UserModel um);
	Long save(UserModel um);
}

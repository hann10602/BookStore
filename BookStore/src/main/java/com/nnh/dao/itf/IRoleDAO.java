package com.nnh.dao.itf;

import com.nnh.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	RoleModel findById(Long id);
}

package com.nnh.dao.imple;

import java.util.List;

import com.nnh.dao.itf.IRoleDAO;
import com.nnh.mapper.RoleMapper;
import com.nnh.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{
	

	@Override
	public RoleModel findById(Long id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		List<RoleModel> lrm = find(sql, new RoleMapper(), id);
		return lrm.isEmpty() ? null : lrm.get(0);
	}

}

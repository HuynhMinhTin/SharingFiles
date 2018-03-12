package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.AdminDAO;
import com.dxc.daoImp.AdminServiceImp;
import com.dxc.entitty.UserEntity;

@Service
public class AdminService implements AdminServiceImp {

	@Autowired
	AdminDAO adminDAO;

	public boolean UpdateUser(UserEntity user) {
		return adminDAO.UpdateUser(user);
	}

	public void DeleteUser(int id) {
		adminDAO.DeleteUser(id);
	}

	public UserEntity findByID(int id) {
		return adminDAO.findByID(id);
	}

	public List<UserEntity> GetAllUser() {
		List<UserEntity> user = adminDAO.GetAllUser();
		return user;
	}


}

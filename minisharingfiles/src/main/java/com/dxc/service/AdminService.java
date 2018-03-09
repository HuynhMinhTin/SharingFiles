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
	AdminDAO admindao;

	public boolean UpdateUser(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DeleteUser(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<UserEntity> GetAllUser() {
		List<UserEntity> user = admindao.GetAllUser();
		return user;
	}

}

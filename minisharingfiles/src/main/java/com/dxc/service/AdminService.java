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

	public void UpdateUser(int id) {
		adminDAO.UpdateUser(id);
	}

	public void DeleteUser(int id) {
		adminDAO.DeleteUser(id);
	}
	public UserEntity LoadUser(int id){
		UserEntity user;
		user=adminDAO.LoadUser(id);
		return user;
		
	}


	public List<UserEntity> GetAllUser() {
		List<UserEntity> user = adminDAO.GetAllUser();
		return user;
	}




}

package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.AdminDAO;
import com.dxc.dao.UserDAO;
import com.dxc.daoImp.AdminServiceImp;
import com.dxc.entitty.LevelUserEntity;
import com.dxc.entitty.UserEntity;

@Service
public class AdminService implements AdminServiceImp {

	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	UserDAO userDAO;

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
	public void UpdateUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		
		adminDAO.UpdateUser(userEntity);
		
	}
	public UserEntity GetInfoUser(int idUser) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = userDAO.GetInfoUser(idUser);
		
		return null;
	}
	public LevelUserEntity GetLeve(int idLevel) {
		// TODO Auto-generated method stub
		LevelUserEntity level = adminDAO.GetLeve(idLevel);
		return level;
	}

}

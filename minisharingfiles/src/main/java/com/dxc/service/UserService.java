package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.UserDAO;
import com.dxc.daoImp.UserDAOImp;
import com.dxc.entitty.UserEntity;


@Service
public class UserService implements UserDAOImp{
	
	
	@Autowired
	UserDAO userDAO;

	public boolean CheckLogin(String email, String password) {
		// TODO Auto-generated method stub
		boolean check = userDAO.CheckLogin(email, password);
		return check;
	}

	public boolean AddEmployees(UserEntity user) {
		// TODO Auto-generated method stub
		boolean check = userDAO.AddEmployees(user);
		return check;
	}

	public int getIDUser() {
		// TODO Auto-generated method stub
		return userDAO.getIDUser();
	}

	public long GetTotalSize(int isUser) {
		// TODO Auto-generated method stub
		long totalSize = userDAO.GetTotalSize(isUser);
		
		return totalSize;
	}


	public boolean UpdateUser(int idUser, long totalSizeOfFile) {
		// TODO Auto-generated method stub
		
		boolean check = userDAO.UpdateUser(idUser, totalSizeOfFile);
		
		return check;
	}

}

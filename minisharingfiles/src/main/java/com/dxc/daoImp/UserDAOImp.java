package com.dxc.daoImp;

import com.dxc.entitty.UserEntity;



public interface UserDAOImp {

	boolean CheckLogin(String email , String password);
	boolean AddEmployees(UserEntity user);
	int getIDUser();
	long GetTotalSize(int isUser);
	
	boolean UpdateUser(int idUser , long totalSizeOfFile);
	
}

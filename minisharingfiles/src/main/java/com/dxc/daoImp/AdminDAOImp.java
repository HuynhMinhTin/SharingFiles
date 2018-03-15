package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.UserEntity;


public interface AdminDAOImp {
	void UpdateUser(int  userId);

	void DeleteUser(int userId);
	UserEntity  LoadUser(int userId);



	List<UserEntity> GetAllUser();



}

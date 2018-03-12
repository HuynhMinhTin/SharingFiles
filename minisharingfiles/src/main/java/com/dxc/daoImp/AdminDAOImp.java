package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.UserEntity;


public interface AdminDAOImp {
	boolean UpdateUser(UserEntity user);

	void DeleteUser(int userId);

	List<UserEntity> GetAllUser();

	UserEntity findByID(int id);

}

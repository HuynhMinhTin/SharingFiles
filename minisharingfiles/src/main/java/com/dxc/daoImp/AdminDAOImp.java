package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.LevelUserEntity;
import com.dxc.entitty.UserEntity;


public interface AdminDAOImp {
	void UpdateUser(UserEntity userEntity);

	void DeleteUser(int userId);
	UserEntity  LoadUser(int userId);

	List<UserEntity> GetAllUser();

	LevelUserEntity GetLeve(int idLevel);

}

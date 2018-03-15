package com.dxc.daoImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.entitty.LevelUserEntity;
import com.dxc.entitty.UserEntity;

@Service
public interface AdminServiceImp{
	void UpdateUser(UserEntity userEntity);
	void DeleteUser(int userId);
	UserEntity LoadUser(int id);

	List<UserEntity> GetAllUser();
	
	UserEntity GetInfoUser(int idUser);
	
	LevelUserEntity GetLeve(int idLevel);
}

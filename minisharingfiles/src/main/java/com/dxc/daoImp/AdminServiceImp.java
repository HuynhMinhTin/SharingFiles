package com.dxc.daoImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.entitty.UserEntity;

@Service
public interface AdminServiceImp{
	void UpdateUser(int userId);
	void DeleteUser(int userId);
	UserEntity LoadUser(int id);

	List<UserEntity> GetAllUser();
}

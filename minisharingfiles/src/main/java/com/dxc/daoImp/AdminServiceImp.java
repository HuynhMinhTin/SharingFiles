package com.dxc.daoImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.entitty.UserEntity;

@Service
public interface AdminServiceImp{
	void UpdateUser(UserEntity user);
	void DeleteUser(int userId);


	List<UserEntity> GetAllUser();
}

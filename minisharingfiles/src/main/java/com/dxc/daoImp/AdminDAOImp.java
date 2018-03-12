package com.dxc.daoImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.entitty.UserEntity;


public interface AdminDAOImp {
	boolean UpdateUser(UserEntity user);

	boolean DeleteUser(UserEntity user);

	List<UserEntity> GetAllUser();
}

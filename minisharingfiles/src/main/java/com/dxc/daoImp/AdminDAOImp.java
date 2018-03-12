package com.dxc.daoImp;

import java.util.List;
import com.dxc.entitty.UserEntity;

public interface AdminDAOImp {
	boolean UpdateUser(UserEntity user);

	boolean DeleteUser(UserEntity user);

	List<UserEntity> GetAllUser();
}

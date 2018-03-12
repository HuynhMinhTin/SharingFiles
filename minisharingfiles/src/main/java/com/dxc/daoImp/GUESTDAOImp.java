package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;

public interface GUESTDAOImp {

	List<FileEntity> GetAllInfoFile();
	List<CategoryEntity> GetCategory();
}

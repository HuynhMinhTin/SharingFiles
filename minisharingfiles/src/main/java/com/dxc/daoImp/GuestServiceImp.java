package com.dxc.daoImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;

@Service
public interface GuestServiceImp {
	
	public List<FileEntity> GetAllInfoFile();
	public List<CategoryEntity> GetCategory();
		
	
}

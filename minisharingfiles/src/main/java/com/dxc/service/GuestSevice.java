package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.CategoryDAO;
import com.dxc.dao.GUESTDAO;
import com.dxc.daoImp.GuestServiceImp;
import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;

@Service
public class GuestSevice implements GuestServiceImp{
	@Autowired
	GUESTDAO GuestDAO;
	@Autowired
	CategoryDAO categoryDAO;

	public List<FileEntity> GetAllInfoFile() {
		// TODO Auto-generated method stub
		List<FileEntity> file = GuestDAO.GetAllInfoFile();
		return file;
	}

	public List<CategoryEntity> GetCategory() {
		// TODO Auto-generated method stub
		List<CategoryEntity> categoryEntities =  categoryDAO.GetCategory();
		return categoryEntities;
	}

}

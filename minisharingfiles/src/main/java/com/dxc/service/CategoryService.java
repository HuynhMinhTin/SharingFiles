package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.CategoryDAO;
import com.dxc.daoImp.CategoryDAOImp;
import com.dxc.entitty.CategoryEntity;

@Service
public class CategoryService implements CategoryDAOImp {

	@Autowired
	CategoryDAO categoryDAO;
	
	public List<CategoryEntity> GetCategory() {
		// TODO Auto-generated method stub
		
		List<CategoryEntity> categoryEntities = categoryDAO.GetCategory();
		
		
		return categoryEntities;
	}

}

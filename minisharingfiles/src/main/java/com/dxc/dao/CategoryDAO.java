package com.dxc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.CategoryDAOImp;
import com.dxc.entitty.CategoryEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryDAO implements CategoryDAOImp{
	
	@Autowired
	SessionFactory sessionFactory ;
	
	@Transactional
	public List<CategoryEntity> GetCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		List<CategoryEntity> categoryEntities = session.createQuery("from category").getResultList();
		
		
		
		return categoryEntities;
	}
	
	
	
}

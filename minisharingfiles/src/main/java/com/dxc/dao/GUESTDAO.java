package com.dxc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.GUESTDAOImp;
import com.dxc.entitty.CategoryEntity;
import com.dxc.entitty.FileEntity;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GUESTDAO implements GUESTDAOImp  {
	@Autowired
	SessionFactory sessionFactory;

	FileEntity fileEntity ;
	
	@Transactional
	public List<FileEntity> GetAllInfoFile() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
			List<FileEntity> resultList = (List<FileEntity>) session.createQuery("from file").list();			
			return resultList;
	}
	
	
	@Transactional
	public List<CategoryEntity> GetCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<CategoryEntity> categoryEntities = session.createQuery("from category").getResultList();
		
		return categoryEntities;
	}

}

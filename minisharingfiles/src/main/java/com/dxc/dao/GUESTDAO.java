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
import com.dxc.entitty.FileEntity;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GUESTDAO implements GUESTDAOImp  {
	@Autowired
	SessionFactory sessionFactory;

	FileEntity fileEntity ;
	@Transactional
	public boolean UploadFile(FileEntity file) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public boolean DownloadFile(FileEntity file) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional
	public List<FileEntity> GetAllInfoFile() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<FileEntity> fileEntity ;		
			List<FileEntity> resultList = (List<FileEntity>) session.createQuery("from file").list();
			fileEntity = resultList;		
			return fileEntity;
	}

}

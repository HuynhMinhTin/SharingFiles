package com.dxc.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.DownloadInterface;
import com.dxc.entitty.FileEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DownloadDAO implements DownloadInterface {
	@Autowired
	SessionFactory sessionFactory;
	
	FileEntity fileEntity;
	
	@Transactional(rollbackOn= {Exception.class})
	public byte[] getDataById(int _id) {
		byte[] data = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "select detail from file where idFile = :id";
		Query query = session.createQuery(hql);
		
		query.setParameter("id", _id);
		data =  (byte[]) query.getSingleResult();
//		System.out.println("data in mySQL: " + data);

		return data;
	}
	
	@Transactional
	public String getFileNameById(int _id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select nameFile from file where idFile = :id";
		Query query = session.createQuery(hql);
		
		query.setParameter("id", _id);
		String fileName = (String)query.getSingleResult();
		
		return fileName;
	}
}

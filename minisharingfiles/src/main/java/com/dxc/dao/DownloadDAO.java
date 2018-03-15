package com.dxc.dao;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.DownloadInterface;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DownloadDAO implements DownloadInterface {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(rollbackOn= {Exception.class})
	public byte[] getDataById(int _id) {
		String hql = "select detail from file where idFile = :id";

		return (byte[]) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("id", _id)
				.getSingleResult();
	}
	
	@Transactional
	public String getFileNameById(int _id) {
		String hql = "select nameFile from file where idFile = :id";

		return (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("id", _id)
				.getSingleResult();
	}

	@Transactional
	public FileEntity getFileById(int _id) {
		String hql = "from file where idFile = :id";
		
		return (FileEntity) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("id", _id)
				.getSingleResult();
	}
	
	@Transactional
	public UserEntity getUserByUserId(int _id) {
		String hql = "from user where idUser = :id";
				
		return (UserEntity) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("id", _id)
				.getSingleResult();
	}

	@Transactional
	public long getSizeFileById(int _id) {
		String hql = "select sizeFile from file where idFile = :id";		
		long result;
		
		try{
			result = (Long) sessionFactory.getCurrentSession()
					.createQuery(hql)
					.setParameter("id", _id)
					.getSingleResult();
		} catch (NoResultException ex){
			result = 0;
		}
		
		return result;
	}

	@Transactional
	public void updateDownloadInformation(int _idFile, int _idUser) {
		String hqlFile = "update file set countDowloadFile = countDowloadFile + 1"
				+ "where idFile = :id"; 
		String hqlUser = "update user set storageDaily = storageDaily + :sizeFile,"
				+ "lastDownLoad = :date "
				+ "where idUser = :id";
		UserEntity user = getUserByUserId(_idUser);
		FileEntity fileEntity = getFileById(_idFile);
		
		sessionFactory.getCurrentSession()
			.createQuery(hqlFile)
			.setParameter("id", _idFile)
			.executeUpdate();
		sessionFactory.getCurrentSession()
			.createQuery(hqlUser)
			.setParameter("date", user.getLastDownload())
			.setParameter("sizeFile", fileEntity.getSizeFile())
			.setParameter("id", user.getIdUser())
			.executeUpdate();		
	}
}

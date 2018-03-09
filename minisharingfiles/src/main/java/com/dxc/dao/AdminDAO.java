package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.AdminDAOImp;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminDAO implements AdminDAOImp {

	@Autowired
	SessionFactory sessionFactory;
	UserEntity userEntity;

	public boolean UpdateUser(UserEntity ad) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(ad);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	public boolean DeleteUser(UserEntity ad) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(ad);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@Transactional
	public List<UserEntity> GetAllUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<UserEntity> userEntity;

		try {
			userEntity = (List<UserEntity>) session.createQuery("from user").setFirstResult(1).list();
			return userEntity;
		} catch (Exception e) {
			// TODO: handle exception
		}
		// return fileEntity;
		return null;

	}

}

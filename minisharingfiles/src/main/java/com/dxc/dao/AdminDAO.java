package com.dxc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.AdminDAOImp;
import com.dxc.entitty.UserEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminDAO implements AdminDAOImp {

	@Autowired
	SessionFactory sessionFactory;
	UserEntity userEntity;

	public boolean UpdateUser(UserEntity user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
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
	public void DeleteUser(int userId) {
		String hql = "delete from user where idUser = :id";
		//String hql = "from user";
		
		sessionFactory.getCurrentSession()
			.createQuery(hql)
			.setParameter("id", userId)			
			.executeUpdate();
		
//		Session session= 	sessionFactory.getCurrentSession();
//		
//		session.createQuery("delete from user where idUser='"+userId+"'").executeUpdate();		
	}



	@Transactional
	public UserEntity findByID(int id) {
		return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
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

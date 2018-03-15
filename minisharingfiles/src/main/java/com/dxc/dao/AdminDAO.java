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
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	SessionFactory sessionFactory;
	UserEntity userEntity;

	@Transactional
	public void DeleteUser(int userId) {

		Session session = sessionFactory.getCurrentSession();

		session.createQuery("delete from file where idUser='" + userId + "'").executeUpdate();

		session.createQuery("delete from user where idUser = :id").setParameter("id", userId).executeUpdate();

	}

	@Transactional
	public void UpdateUser(int userId) {

		Session session = sessionFactory.getCurrentSession();
		session.createQuery("UPDATE  user set idLevel= :idLevel" + "WHERE idUser= :id ")
				.setParameter("id", userId).executeUpdate();
		session.createQuery("UPDATE  user set nameUser= :nameUser" + "WHERE idUser= :id ")
				.setParameter("id", userId).executeUpdate();

	}

	@Transactional
	public List<UserEntity> GetAllUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<UserEntity> userEntity;

		userEntity = (List<UserEntity>) session.createQuery("from user").setFirstResult(1).list();
		return userEntity;

	}

	@Transactional
	public UserEntity LoadUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(userId);
		UserEntity user;
		user = (UserEntity) session.createQuery("from user where idUser = :id").setParameter("id", userId)
				.getSingleResult();
		return user;
	}

}

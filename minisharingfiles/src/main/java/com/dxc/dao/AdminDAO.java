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
	        return sessionFactory;}


	@Autowired
	SessionFactory sessionFactory;
	UserEntity userEntity;



	@Transactional
	public void DeleteUser(int userId) {
		String hql = "delete from user where idUser = :id";
		//String hql = "from user";
		
		sessionFactory.getCurrentSession()
			.createQuery(hql)
			.setParameter("id", userId)			
			.executeUpdate();

	}@Transactional
	public void UpdateUser(UserEntity user) {
		sessionFactory.getCurrentSession().update(userEntity);

	}
	 

	@Transactional
	public List<UserEntity> GetAllUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<UserEntity> userEntity;

			userEntity = (List<UserEntity>) session.createQuery("from user").setFirstResult(1).list();
			return userEntity;
	
	}

}

package com.dxc.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.UserDAOImp;
import com.dxc.entitty.UserEntity;



@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAO implements UserDAOImp{

	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	public boolean CheckLogin(String email, String password) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		String firstLetter ="";
		System.out.println(email);
		try{
			
			UserEntity user = (UserEntity) session.createQuery("from user where emailUser='"+email+"' AND passwordUser='"+password+"'").getSingleResult();
			
			if(user != null){
				
					System.out.println(user.getEmailUser());
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			
		}
		
		
		return false;
	}
	
	
	@Transactional
	public boolean AddEmployees(UserEntity user) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		String emailUser = user.getEmailUser();
		
		//System.out.println(user.getEmailUser());
		//check email exist in server
		try {
			UserEntity email = (UserEntity) session.createQuery("from user where emailUser='"+emailUser+"'").getSingleResult();
			if(email.getEmailUser() != null){	
				System.out.println(emailUser);
				return false;
			}
		}catch(Exception e) {
			Session sessionUser = sessionFactory.getCurrentSession();
			int idUser = (Integer) sessionUser.save(user);
			if(idUser > 0) {
				System.out.println(emailUser +"OK");
				return true;
			}else {
				System.out.println(emailUser + "wrong");
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
}

package com.dxc.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.UserDAOImp;
import com.dxc.entitty.LevelUserEntity;
import com.dxc.entitty.UserEntity;



@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAO implements UserDAOImp{

	@Autowired
	SessionFactory sessionFactory;

	UserEntity user ;
	
	@Transactional
	public boolean CheckLogin(String email, String password) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		String firstLetter ="";
		//System.out.println(email);
		try{
			
			user = (UserEntity) session.createQuery("from user where emailUser='"+email+"' AND passwordUser='"+password+"'").getSingleResult();
			
			if(user != null){
					//System.out.println(user.getEmailUser());
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			
		}
		
		
		return false;
	}
	
	public int getIDUser() {
		
		return user.getIdUser();
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
	
	@Transactional
	public long GetTotalSize(int isUser) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
			long totalSize = (Long) session.createQuery("select totalSize from user where idUser='"+isUser+"'").getSingleResult();
			return totalSize;
	}

	
	@Transactional
	public boolean UpdateUser(int idUser, long totalSize) {
		// TODO Auto-generated method stub
		
		
		Session session = sessionFactory.getCurrentSession();
		
		UserEntity user = 	(UserEntity) session.createQuery("from user where idUser='"+idUser+"'").getSingleResult();
		
		/*UserEntity userUpdate = new UserEntity();
		userUpdate.setIdUser(user.getIdUser());
		userUpdate.setEmailUser(user.getEmailUser());
		userUpdate.setPasswordUser(user.getPasswordUser());
		userUpdate.setNameUser(user.getNameUser());
		userUpdate.setIdPosition(user.getIdPosition());
		userUpdate.setTotalSize(totalSize);*/
		
		
		LevelUserEntity levelUser = new LevelUserEntity();
		levelUser =user.getIdLevel();
		

		int checkUpdateLevel = levelUser.getIdLevel();
		
		System.out.println("This is a old level of user : " + checkUpdateLevel );
		
		if(checkUpdateLevel == 1){
			if(totalSize >= 20971520){
				LevelUserEntity levelUserUpdated = new LevelUserEntity();
				levelUserUpdated.setIdLevel(2);
				user.setIdLevel(levelUserUpdated);
				//levelUser.setIdLevel(2);
			}
		}
		else if(checkUpdateLevel == 2){
			if(totalSize >= 52428800){
				LevelUserEntity levelUserUpdated = new LevelUserEntity();
				levelUserUpdated.setIdLevel(3);
				user.setIdLevel(levelUserUpdated);
			}
		}
		else{
		}
		user.setTotalSize(totalSize);
		
		
		session.update(user);
		
		return true;
	}


}

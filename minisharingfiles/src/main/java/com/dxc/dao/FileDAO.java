package com.dxc.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.daoImp.FileDAOImp;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.LevelUserEntity;
import com.dxc.entitty.UserEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FileDAO implements FileDAOImp {
	
	

	@Autowired
	SessionFactory sessionFactory;

	FileEntity fileEntity ;
	
	
	@Transactional
	public boolean UploadFile(FileEntity file) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			
			int fileCount = (Integer) session.save(file);
			//session.clear();
			//System.out.println(fileCount);
			if(fileCount > 0) {
				System.out.println(file.getNameFile() +"OK");
				return true;
			}else {
				System.out.println(file.getNameFile() + "wrong");
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}

	
	@Transactional
	public boolean DownloadFile(FileEntity file) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Transactional
	public List<FileEntity> GetInfoFile(int idUser) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<FileEntity> fileEntity ;
		
		try {
			fileEntity = (List<FileEntity>) session.createQuery("from file where idUser='"+idUser+"'").getResultList();		
			return fileEntity;
		} catch (Exception e) {
			// TODO: handle exception
		}
	//	return fileEntity;
		return null;
		
	}

	@Transactional
	public int GetIdUser(int idUser) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		LevelUserEntity levelUserEntity = new LevelUserEntity();
		try {
			UserEntity userEntity = (UserEntity) session.createQuery("from user where idUser='"+idUser+"'").getSingleResult();
			levelUserEntity = userEntity.getIdLevel();
			int idLevel = levelUserEntity.getIdLevel();
			System.out.println(idLevel);
			return idLevel;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}


	public int GetTotalSize(int isUser) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		LevelUserEntity levelUserEntity = new LevelUserEntity();
		try {
			UserEntity userEntity = (UserEntity) session.createQuery("from user where idUser='"+isUser+"'").getSingleResult();
			levelUserEntity = userEntity.getIdLevel();
			int idLevel = levelUserEntity.getIdLevel();
			System.out.println(idLevel);
			return idLevel;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}

}

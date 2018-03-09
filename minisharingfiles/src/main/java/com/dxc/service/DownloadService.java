package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.DownloadDAO;
import com.dxc.daoImp.DownloadInterface;

@Service
public class DownloadService implements DownloadInterface{
	@Autowired
	DownloadDAO downloadDao;
		
	public byte[] getDataById(int _id) {		
		return downloadDao.getDataById(_id);
	}

	public String getFileNameById(int _id) {		
		return downloadDao.getFileNameById(_id);
	}
}

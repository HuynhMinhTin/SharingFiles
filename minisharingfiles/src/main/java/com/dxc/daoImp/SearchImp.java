package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.FileEntity;

public interface SearchImp {
	
	List<FileEntity> SearchFile(String keyword);

	void indexBooks() throws Exception ;
	
}

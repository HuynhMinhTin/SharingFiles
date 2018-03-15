package com.dxc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dxc.daoImp.SearchImp;
import com.dxc.entitty.FileEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SearchDAO implements SearchImp{

	@Autowired
	SessionFactory sessionFactory ;
	
	@Transactional
	public void indexBooks() throws Exception  {
		try {
			Session session = sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	/*@Transactional
	public List<FileEntity> SearchFile(String keyword) {
		// TODO Auto-generated method stub
		
		//System.out.println(keyword);
		Session session = sessionFactory.getCurrentSession();
		
		FullTextSession fullTextSession = Search.getFullTextSession(session);

		
		QueryBuilder queryBuilder =fullTextSession.getSearchFactory()
									.buildQueryBuilder().forEntity(FileEntity.class ).get();
		
		org.apache.lucene.search.Query query = queryBuilder.keyword()
															.onFields("nameFile")//colum to search
															.matching(keyword)
															.createQuery();
		
		
		
		System.out.println(query.toString());
	
		org.hibernate.Query hibQuery =  fullTextSession.createFullTextQuery(query,FileEntity.class);
		((FullTextQuery) fullTextSession).initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
		
		
		org.hibernate.search.FullTextQuery fulltextquery= fullTextSession.createFullTextQuery(query,FileEntity.class);
	
		System.out.println(fulltextquery);
		List<FileEntity> results = fulltextquery.getResultList();
		
		
		
		for(FileEntity f : results){
			System.out.println(f.toString());
		}
		return results;
	}*/


	@Override
	@Transactional
	public List<FileEntity> SearchFileHQL(String keyword) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ;
		
		String query = "%" + keyword +"%";
		
		List<FileEntity> fileEntities = (List<FileEntity>)session.createQuery("from file where nameFile LIKE '"+query+"'").getResultList();
		
		
		return fileEntities;
	}


	@Override
	public List<FileEntity> SearchCategory(String keyword, int idCategory) {
		// TODO Auto-generated method stub
		
		
		Session session = sessionFactory.getCurrentSession() ;
		
		String query = "%" + keyword +"%";
		
		List<FileEntity> fileEntities = (List<FileEntity>)session.createQuery("from file where nameFile LIKE '"+query+"' AND idCategory='"+idCategory+"'").getResultList();
		
		
		return fileEntities;
	}


	@Override
	public List<FileEntity> SearchFile(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

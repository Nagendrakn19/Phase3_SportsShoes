package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Report;



@Repository
public class ReportDao {

	@Autowired
	EntityManagerFactory emf;
	
	public List<Report> getAllReport()
	{
		EntityManager manager = emf.createEntityManager();
		
		//JPQL Java Persistence Query Language
		Query qry = manager.createQuery("select r from Report r");
		List<Report> list=qry.getResultList();
		return list;
	}
}

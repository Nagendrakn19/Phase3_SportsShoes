package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public class UserDao {

	
	@Autowired
	EntityManagerFactory emf; 
	
	public List<User> getSingedUpUsers()
	{
		EntityManager manager = emf.createEntityManager();
		
		//JPQL Java Persistence Query Language
		Query qry = manager.createQuery("select u from User u");
		List<User> list=qry.getResultList();
		return list;
	}
	
	
	public User findUserById(int id)
	{
		EntityManager manager = emf.createEntityManager();
		User u=manager.find(User.class, id);
		return u;
	}
}

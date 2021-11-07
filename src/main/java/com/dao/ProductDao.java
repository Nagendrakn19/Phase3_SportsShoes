package com.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admin;
import com.bean.Product;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;
	
	public List<Product> getAllProduct()
	{
		EntityManager manager = emf.createEntityManager();
		
		//JPQL Java Persistence Query Language
		Query qry = manager.createQuery("select p from Product p");
		List<Product> list=qry.getResultList();
		return list;
	}
	
	public boolean storeProductRecord(Product pro)
	{
		try
		{
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.persist(pro);
			tran.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public int updateProductRecord(Product pro)
	{
		EntityManager manager = emf.createEntityManager();
		Product p = manager.find(Product.class, pro.getId());
		if(p==null)
		{
			return 0;
		}
		else
		{
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			p.setPrice(pro.getPrice());
			p.setCategory(pro.getCategory());
			manager.merge(p);
			tran.commit();
			return 1;
		}
	}
	
	public int deleteProductRecord(int id)
	{
		EntityManager manager = emf.createEntityManager();
		Product p=manager.find(Product.class, id);
		if(p==null)
		{
			return 0;
		}
		else
		{
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.remove(p);
			tran.commit();
			return 1;
		}
	}
	
	public Product findProductusingId(int id)
	{
		EntityManager manager = emf.createEntityManager();
		Product p=manager.find(Product.class, id);
		return p;
	}
	
	
	//Update Admin password
	
	public int updatePass(Admin ad)
	{
		EntityManager manager = emf.createEntityManager();
		Admin a1 = manager.find(Admin.class, ad.getId());
		if(a1==null)
		{
			return 0;
		}
		else
		{
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			a1.setPass(ad.getPass());
			manager.merge(a1);
			tran.commit();
			return 1;
		}
	}
	
	
}
	

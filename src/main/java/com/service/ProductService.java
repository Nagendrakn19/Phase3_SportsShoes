package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.bean.Product;
import com.dao.ProductCategory;
import com.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductCategory productCategory;
	
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	
	public String storeProductRecord(Product pro)
	{
		if(productDao.storeProductRecord(pro))
		{
			return "Stored successfully";
		}
		else
		{
			return "Didn't store";
		}
	}
	
	public String updateProductRecord(Product pro)
	{
		if(productDao.updateProductRecord(pro)>0)
		{
			return "Record updated successfully";
		}
		else
		{
			return "Record didn't update";
		}
	}
	
	public String deleteProductRecord(int id)
	{
		if(productDao.deleteProductRecord(id)>0)
		{
			return "Record deleted";
		}
		else
		{
			return "Record didn't delete";
		}
	}
	
	public Product findProductusingId(int id)
	{
		return productDao.findProductusingId(id);
		}
	
	
	public List<Product> getAllProductBasedOnCategory(String category) {
		return productCategory.findAllByCategory(category);
	}
	
	//Update admin Password
	
	public String updatePass(Admin ad)
	{
		if(productDao.updatePass(ad)>0)
		{
			return "Record updated successfully";
		}
		else
		{
			return "Record didn't update";
		}
	}
}

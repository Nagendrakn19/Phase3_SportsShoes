package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Admin;
import com.bean.Product;
import com.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	

					/* Product operstions */
	
	//http://localhost:9191/multipleQuery?name=admin&pass=admin
	@RequestMapping(value="multipleQuery", method=RequestMethod.GET)
	public String multipleQuery(@RequestParam("name")String name,@RequestParam("pass") String pass)
	{
	if(name.equals("admin") && pass.equals("admin"))
	{
		return "Welcome Admin";
	}
	else
	{
		return "Please enter proper admin credentials";
	}
}
	
	//Update Admin password
	//http://localhost:9191/updatePass
		@RequestMapping(value="updatePass",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updatePass(@RequestBody Admin ad)
		{
			return productService.updatePass(ad);
	}
	
	
	//http://localhost:9191/products
	@GetMapping("/products")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	
	//http://localhost:9191/storeProduct
	@RequestMapping(value="storeProduct",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product pro)
	{
		return productService.storeProductRecord(pro);
		
	}
	
	//http://localhost:9191/updateProduct
	@RequestMapping(value="updateProduct",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody Product pro)
	{
		return productService.updateProductRecord(pro);
}
	
	//http://localhost:9191/deleteProduct/7
	@RequestMapping(value="deleteProduct/{id}",method=RequestMethod.DELETE)
	public String deleteProductRecord(@PathVariable("id") int id)
	{
		return productService.deleteProductRecord(id);
}
	
	//http://localhost:9191/findProduct/1
	@RequestMapping(value="findProduct/{id}",method = RequestMethod.GET)
	public Product findProductRecordById(@PathVariable("id") int id)
	{
		return productService.findProductusingId(id);
	}
	
	//http://localhost:9191/products/category/Runningshoes
	@GetMapping("/products/category/{category}")
	public ResponseEntity<List<Product>> getAllProductsBasedOnCategory(@PathVariable("category") String category) {
		List<Product> allProductsBasedOnCategory = productService.getAllProductBasedOnCategory(category);
		if (allProductsBasedOnCategory.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(allProductsBasedOnCategory,
				HttpStatus.OK);
		return responseEntity;
	}
	



}

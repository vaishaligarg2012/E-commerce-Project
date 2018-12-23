package com.MVCStart.Daos;

import java.util.List;

import com.MVCStart.Models.Product;

public interface ProductDao {
   
	public boolean addProduct(Product product);
    public List<Product> viewAllProduct();
    public Product viewProductById(int id);
    public boolean deleteProduct(Product product);
    public boolean updateProduct(Product product);
}

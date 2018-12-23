package com.MVCStart.Daos;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.MVCStart.Models.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
              
	@Autowired
	SessionFactory sessionFactory;
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
		    session.save(product);
		    return true;
   		}catch(Exception e) {
 			e.printStackTrace();
		}
	    
		return false;
	}


	public List<Product> viewAllProduct() {
		// TODO Auto-generated method stub
	try {
	    Session session = sessionFactory.getCurrentSession();
	    Query q = session.createQuery("from Product");
	    List<Product> list =q.getResultList();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public Product viewProductById(int id) {
		// TODO Auto-generated method stub
		try {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product)session.get("from Product", id);
		return product;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
    
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

 public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

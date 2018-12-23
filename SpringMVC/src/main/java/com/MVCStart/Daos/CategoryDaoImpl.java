package com.MVCStart.Daos;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MVCStart.Models.Category;

@Transactional
@Repository("CategoryDao")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Category> viewAllCategory() {
		// TODO Auto-generated method stub
		try {
            Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from Category");
			List<Category> result = query.getResultList();
			return result;	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Category viewCategoryById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session =sessionFactory.getCurrentSession();
			Category s	= (Category)session.get(Category.class, id);
			return s;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub

		try {
			Session session =sessionFactory.getCurrentSession();
			session.update(category);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

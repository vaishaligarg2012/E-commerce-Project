package com.MVCStart.Daos;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.MVCStart.Models.Address;
import com.MVCStart.Models.Supplier;

@Repository("SupplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	@Qualifier("sessionFactory")


	@Autowired
	SessionFactory sessionFactory;
	public boolean addSupplier(Supplier obj,Address address ) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.openSession();
			Transaction t=session.beginTransaction();
			session.save(obj);
			session.save(address);
			t.commit();
			session.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Supplier> viewAllSupplier() {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Supplier");
			List<Supplier>  result= query.getResultList();
			return result;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Supplier viewAllSupplierById(int id) {
		// TODO Auto-generated method stub
		try {
			Session s = sessionFactory.getCurrentSession();
			Supplier supplier = (Supplier) s.get(Supplier.class, id);
			return supplier;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean updateSupplier(Supplier supplier, Address address) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(supplier);
			session.update(address);
			return true;
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

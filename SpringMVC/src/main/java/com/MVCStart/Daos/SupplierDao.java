package com.MVCStart.Daos;

import java.util.List;

import com.MVCStart.Models.Address;
import com.MVCStart.Models.Supplier;

public interface SupplierDao {
          public boolean addSupplier(Supplier obj, Address address);
          public List<Supplier> viewAllSupplier();
          public Supplier viewAllSupplierById(int id);
          public boolean deleteSupplier(Supplier supplier);
          public boolean updateSupplier(Supplier supplier, Address address);
}

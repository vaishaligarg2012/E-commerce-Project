package com.MVCStart;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.MVCStart.DBConfig.DBConfig;
import com.MVCStart.Daos.CategoryDao;
import com.MVCStart.Daos.ProductDao;
import com.MVCStart.Daos.SupplierDao;
import com.MVCStart.Models.Address;
import com.MVCStart.Models.Category;
import com.MVCStart.Models.Product;
import com.MVCStart.Models.Supplier;


public class AppTest 
{
     static CategoryDao categoryDao;
     static SupplierDao supplierDao;
     static ProductDao productDao;
     
     @BeforeClass
     public static void myInit() {
    	 @SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	 context.register(DBConfig.class);
    	 context.refresh();
    	 categoryDao= context.getBean("CategoryDao", CategoryDao.class);
    	 supplierDao= context.getBean("SupplierDao", SupplierDao.class);
    	 productDao=context.getBean("productDao",ProductDao.class);
     }
     
     @Test
     @Ignore
     public void addCategoryTest() {
      Category cat=new Category();	 
      cat.setCatName("Mens Wear");
      cat.setCatDescription("Some description");
      boolean test= categoryDao.addCategory(cat);
      assertTrue("Category is not added", test);
      }
     
     @Test
     @Ignore
     public void addSupplierTest() {
    	 Supplier sup=new Supplier();
    	 Address address= new Address();
         
    	 address.setPincode(201307);
    	 address.setAddressLine("B-521 ,Delhi Road");
    	 address.setCity("Gurugram");
    	 address.setState("Haryana");
    	 
    	 sup.setSupplierEmail("abc@gmail.com");
    	 sup.setSupplierMobile("1234567");  
    	 sup.setSupplierName("jhgf");
         sup.setAddress(address);
        
         boolean test = supplierDao.addSupplier(sup,address);
    	 assertTrue("Supplier added",test);
     }
     
     @Test
     @Ignore
     public void getAllCategories() {
    	 Category obj = new Category();
         List<Category> result = categoryDao.viewAllCategory();
         for(Category r: result) {
        	 System.out.println(r.getCatDescription()+" "+r.getCatName());
         }
    	 assertTrue("No Category found ",result.size()<0);

     }
     
     @Test
     @Ignore
     public void getCategoryById() {
    	 Category result = (Category)categoryDao.viewCategoryById(1);
    	 System.out.println(result.getCatDescription());
    	 assertNotNull("No Category found", result);
     }
     @Test
     @Ignore
     public void deleteCategoryTestCase() {
    	 Category result = (Category)categoryDao.viewCategoryById(1);
         boolean d= categoryDao.deleteCategory(result);
         assertTrue("Remove success", d);
    	 
     }
     
     @Test
     @Ignore
     public void updateCategoryTestCase() {
    	 Category category =categoryDao.viewCategoryById(8);
    	 category.setCatName("Women wear");
    	 boolean t = categoryDao.updateCategory(category);
         assertTrue("Update success", t);
     }
     
     
     @Test
     @Ignore
     public void addProductTestCase() {
    	   Product product = new Product();
    	  // product.setPrice(989);
    	   product.setProductDescription("T-Shirt Descrition");
    	   product.setProductName("T-Shirt");
    	   product.setQuantity(10);
    	   product.setSupplierId(101);
    	   product.setCategoryId(102);
    	   boolean b= productDao.addProduct(product);
    	   assertTrue("Product Added", b);
    	   
     }
}

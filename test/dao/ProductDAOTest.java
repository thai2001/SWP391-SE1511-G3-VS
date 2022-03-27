/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package dao;

import entity.Product;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taola
 */
public class ProductDAOTest {
    
    public ProductDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllProducts method, of class ProductDAO.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        System.out.println("getAllProducts");
        ProductDAO instance = new ProductDAO();
        Vector<Product> expResult = null;
        Vector<Product> result = instance.getAllProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllProductsByVehicleTypeId method, of class ProductDAO.
     */
    @Test
    public void testGetAllProductsByVehicleTypeId() throws Exception {
        System.out.println("getAllProductsByVehicleTypeId");
        int vtid = 0;
        ProductDAO instance = new ProductDAO();
        Vector<Product> expResult = null;
        Vector<Product> result = instance.getAllProductsByVehicleTypeId(vtid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllProductsWithCondition method, of class ProductDAO.
     */
    @Test
    public void testGetAllProductsWithCondition() throws Exception {
        System.out.println("getAllProductsWithCondition");
        int vtid = 0;
        int brandId = 0;
        String keyWord = "";
        String sort = "";
        ProductDAO instance = new ProductDAO();
        Vector<Product> expResult = null;
        Vector<Product> result = instance.getAllProductsWithCondition(vtid, brandId, keyWord, sort);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProductById method, of class ProductDAO.
     */
    @Test
    public void testGetProductById() throws Exception {
        System.out.println("getProductById");
        int pid = 0;
        ProductDAO instance = new ProductDAO();
        Product expResult = null;
        Product result = instance.getProductById(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNumberOfPage method, of class ProductDAO.
     */
    @Test
    public void testGetNumberOfPage() throws Exception {
        System.out.println("getNumberOfPage");
        ProductDAO instance = new ProductDAO();
         int result = instance.getNumberOfPage(1, 0, "");
        assertTrue(result >= 1);
        result = instance.getNumberOfPage(2, 0, "");
        assertTrue(result >= 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProductInPage method, of class ProductDAO.
     */
    @Test
    public void testGetProductInPage() throws Exception {
        System.out.println("getProductInPage");
        int index = 0;
        int vtid = 0;
        int brandId = 0;
        String keyWord = "";
        String sort = "";
        ProductDAO instance = new ProductDAO();
        Vector<Product> expResult = null;
        Vector<Product> result = instance.getProductInPage(0, 1, brandId, keyWord, "newest");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

   
   
    
}

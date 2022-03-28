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
   

    /**
     * Test of getAllProductsByVehicleTypeId method, of class ProductDAO.
     */
    @Test
    public void testGetAllProductsByVehicleTypeId() throws Exception {
        System.out.println("getAllProductsByVehicleTypeId");
        int vtid = 0;
        ProductDAO instance = new ProductDAO();
        Vector<Product> result = instance.getAllProductsByVehicleTypeId(1);
        assertNotNull(result);
        result = instance.getAllProductsByVehicleTypeId(2);
        assertNotNull(result);
        result = instance.getAllProductsByVehicleTypeId(3);
        assertEquals(0,result.size());
        result = instance.getAllProductsByVehicleTypeId(4);
        assertEquals(0,result.size());

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllProductsWithCondition method, of class ProductDAO.
     */
    @Test
    public void testGetAllProductsWithCondition() throws Exception {
        System.out.println("getAllProductsWithCondition");
       
        ProductDAO instance = new ProductDAO();
        Vector<Product> result = instance.getAllProductsWithCondition(1, 1, "", "ManufactureYear desc");
        assertNotNull(result);
        result = instance.getAllProductsWithCondition(1, 2, "", "ManufactureYear desc");
        assertNotNull(result);
        result = instance.getAllProductsWithCondition(1, 2, "a", "ManufactureYear desc");
        assertNotNull(result);
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
        Product result = instance.getProductById(1);
        assertNotNull(result);
         result = instance.getProductById(2);
        assertNotNull(result);
         result = instance.getProductById(3);
        assertNotNull(result);
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
        result = instance.getNumberOfPage(2, 0, "a");
        assertTrue(result >= 1);
        result = instance.getNumberOfPage(1, 0, "b");
        assertTrue(result >= 1);
        result = instance.getNumberOfPage(2, 0, "f");
        assertTrue(result == 0);
        result = instance.getNumberOfPage(3, 0, "");
        assertTrue(result == 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProductInPage method, of class ProductDAO.
     */
    @Test
    public void testGetProductInPage() throws Exception {
        System.out.println("getProductInPage");

        ProductDAO instance = new ProductDAO();
        Vector<Product> result = instance.getProductInPage(1, 1, 2, "a", "ManufactureYear desc");
        assertNotNull(result);
        result = instance.getProductInPage(1, 1, 1, "a", "ManufactureYear desc");
        assertNotNull(result);
        result = instance.getProductInPage(1, 1, 2, "", "ManufactureYear desc");
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

}

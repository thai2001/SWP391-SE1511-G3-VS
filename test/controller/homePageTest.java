/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class homePageTest {
    
    public homePageTest() {
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
     * Test of processRequest method, of class homePage.
     */
//    @Test
//    public void testProcessRequest() throws Exception {
//        System.out.println("processRequest");
//        HttpServletRequest request = null;
//        HttpServletResponse response = null;
//        homePage instance = new homePage();
//        instance.processRequest(request, response);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of doGet method, of class homePage.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        homePage instance = new homePage();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of doPost method, of class homePage.
     */
//    @Test
//    public void testDoPost() throws Exception {
//        System.out.println("doPost");
//        HttpServletRequest request = null;
//        HttpServletResponse response = null;
//        homePage instance = new homePage();
//        instance.doPost(request, response);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
}

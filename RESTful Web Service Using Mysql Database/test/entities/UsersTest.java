/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
public class UsersTest {
    
    public UsersTest() {
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
     * Test of getId method, of class Users.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Users instance = new Users();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Users.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Users instance = new Users();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreEmp method, of class Users.
     */
    @Test
    public void testGetNombreEmp() {
        System.out.println("getNombreEmp");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getNombreEmp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreEmp method, of class Users.
     */
    @Test
    public void testSetNombreEmp() {
        System.out.println("setNombreEmp");
        String nombreEmp = "";
        Users instance = new Users();
        instance.setNombreEmp(nombreEmp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidoEmp method, of class Users.
     */
    @Test
    public void testGetApellidoEmp() {
        System.out.println("getApellidoEmp");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getApellidoEmp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidoEmp method, of class Users.
     */
    @Test
    public void testSetApellidoEmp() {
        System.out.println("setApellidoEmp");
        String apellidoEmp = "";
        Users instance = new Users();
        instance.setApellidoEmp(apellidoEmp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccionEmp method, of class Users.
     */
    @Test
    public void testGetDireccionEmp() {
        System.out.println("getDireccionEmp");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getDireccionEmp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccionEmp method, of class Users.
     */
    @Test
    public void testSetDireccionEmp() {
        System.out.println("setDireccionEmp");
        String direccionEmp = "";
        Users instance = new Users();
        instance.setDireccionEmp(direccionEmp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Users.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Users instance = new Users();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Users.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Users instance = new Users();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Users.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Users instance = new Users();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

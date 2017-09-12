/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiotreatmentlib;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Богдан
 */
public class CalculationsTest {
    
    public CalculationsTest() {
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
     * Test of getRange method, of class Calculations.
     */
    @Test
    public void testGetRange() {
        System.out.println("getRange");
        byte[] sound = new byte[] {2, 4, 5, 6, 7, 1, 0};
        byte[] expResult = {0, 7};
        byte[] result = Calculations.getRange(sound);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getEnergy method, of class Calculations.
     */
    @Test
    public void testGetEnergy() {
        System.out.println("getEnergy");
        byte[] sound = new byte[] {2, 4, 5, 6, 7, 1, 0};
        int expResult = 4 + 16 + 25 + 36 + 49 + 1 + 0;
        int result = Calculations.getEnergy(sound);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPower method, of class Calculations.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        byte[] sound = new byte[] {2, 4, 5, 6, 7, 1, 0};
        float expResult = (4 + 16 + 25 + 36 + 49 + 1 + 0) / 7;
        float result = Calculations.getPower(sound);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getMX method, of class Calculations.
     */
    @Test
    public void testGetMX() {
        System.out.println("getMX");
        byte[] sound = new byte[] {5, 6, 4, 6};
        float expResult = 5.25F;
        float result = Calculations.getMX(sound);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getDX method, of class Calculations.
     */
    @Test
    public void testGetDX() {
        System.out.println("getDX");
        byte[] sound = new byte[] {1, 3, 5};
        float expResult = 2.66F;
        float result = Calculations.getDX(sound);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }
    
}

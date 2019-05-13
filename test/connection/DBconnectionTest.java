/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import controller.connection.DBconnection;
import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quang Thái
 */
public class DBconnectionTest {

    public DBconnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getConnect method, of class DBconnection.
     */
    @Test
    public void testGetConnect() {
        System.out.println("getConnect");
        String expResult = "com.mysql.jdbc.JDBC4Connection@61443d8f";
        Connection result = DBconnection.getConnect();
        assertEquals(expResult, result.toString());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of main method, of class DBconnection.
     */
}

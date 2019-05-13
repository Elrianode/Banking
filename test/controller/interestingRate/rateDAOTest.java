/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interestingRate;

import controller.DAO.CustomerDAO;
import controller.DAO.interestingRate.rateDAO;
import controller.connection.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quang Thái
 */
public class rateDAOTest {

    private static Connection connection;

    public rateDAOTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        DBconnection dbConnection = new DBconnection();
        connection = dbConnection.getConnect();
        try {
            connection.setAutoCommit(false);
//            String strSQL = "SELECT COUNT(`id`) FROM `interestrate` WHERE 1=1 ";
//
//            Statement comm = connection.createStatement();
//            ResultSet rs = comm.executeQuery(strSQL);
        } catch (SQLException e) {
            System.out.println("" + e);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("" + e);
        }
    }

    /**
     * Test of getRate method, of class rateDAO.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        String month = "m1";
        rateDAO instance = new rateDAO();
        int kq = 0;
        int id = 1;
        Connection connection;
        DBconnection dbConnection = new DBconnection();
        connection = dbConnection.getConnect();
        String strSQL = "SELECT `" + month + "` FROM `interestrate` WHERE `id`= '" + id + "'  ";
        try {
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                float x = rs.getFloat(month);
            }
        } catch (SQLException e) {
            System.err.println("" + e);
        }
        float expResult = (float) 0.8;
        float result = (float) instance.getRate(month, id);
        System.out.println("" + result + "  " + expResult);
        if (expResult == result) {
            kq = 1;
        }
        assertEquals(kq, 1);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of changeRate method, of class rateDAO.
     */
    @Test
    public void testChangeRate() {
        System.out.println("changeRate");
        String month = "m3";
        int kq = 0;
        double rate = 0.1;
        int id = 1;
        rateDAO instance = new rateDAO();
        float expResult = (float) 0.1;
        float kq1 = -1;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String strSQL = "SELECT `" + month + "` FROM `interestrate` WHERE `id`= '" + id + "'  ";

            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                kq1 = rs.getFloat(month);
            }

        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        float result = instance.getRate(month, id);
        System.out.println(result + "  " + expResult);
        if (result == expResult) {
            kq = 1;
        }
        assertEquals(kq, 1);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getDate method, of class rateDAO.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        rateDAO instance = new rateDAO();
        Date date = new Date();
        String kq = "";
        int id = 1;

        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT `created_at` FROM `interestrate` WHERE `id`='" + id + "'";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            while (rs.next()) {
                kq = rs.getString("created_at");
            }
            String expResult = kq;
        } catch (Exception e) {
            Logger.getLogger(rateDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        String expResult = "Thu May 09 19:21:02 ICT 2019";
        String result = instance.getDate(id).toString();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setDate method, of class rateDAO.
     */
//    @Test
//    public void testSetDate() {
//        System.out.println("setDate");
//        Date date = null;
//        rateDAO instance = new rateDAO();
//        boolean expResult = false;
//        boolean result = instance.setDate(date);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

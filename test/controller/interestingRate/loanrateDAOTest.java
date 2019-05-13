/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interestingRate;

import controller.DAO.interestingRate.loanrateDAO;
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
public class loanrateDAOTest {

    private static Connection connection;

    public loanrateDAOTest() {
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
     * Test of getCurrentNumberRate method, of class loanrateDAO.
     */
    @Test
    public void testGetCurrentNumberRate() {
        int kq = -1;
        System.out.println("getCurrentNumberRate");
        loanrateDAO instance = new loanrateDAO();
        DBconnection dbConnection = new DBconnection();
        connection = dbConnection.getConnect();
        String strSQL = "SELECT COUNT(`id`) FROM `loanrate` WHERE 1=1 ";
        try {
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                kq = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("" + e);

        }
        int expResult = kq;
        int result = instance.getCurrentNumberRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getRate method, of class loanrateDAO.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        String month = "6month";
        int idrate = 1;
        loanrateDAO instance = new loanrateDAO();
        Double expResult = 1.2000000476837158;
        float result = instance.getRate(month, idrate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of changeRate method, of class loanrateDAO.
     */
    @Test
    public void testChangeRate() {
        System.out.println("changeRate");
        double rate0 = 1.2;
        double rate1 = 1.0;
        double rate3 = 0.8;
        String date = "2019-05-09 00:00:00.0";
        loanrateDAO instance = new loanrateDAO();
        boolean expResult;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            boolean rs = false;
            String strSQL = "INSERT INTO `loanrate` (6month,12month,36month,created_at)\n"
                    + "VALUES ('" + rate0 + "','" + rate1 + "','" + rate3 + "','" + date + "'); ";
            System.out.println("" + strSQL);
            Statement comm = connection.createStatement();
            rs = (comm.executeUpdate(strSQL) > 0);
            expResult = true;

        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            expResult = false;

        }
        boolean result = instance.changeRate(rate0, rate1, rate3, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getDate method, of class loanrateDAO.
     */
}

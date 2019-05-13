/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import Model.SavingAccount;
import controller.DAO.SavingAccountDAO;
import controller.common.BankAccountGenID;
import controller.common.DateTimeFomater;
import controller.connection.DBconnection;
import Model.Customer;
import controller.DAO.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.runner.*;

/**
 *
 * @author phamhoanganh
 */
public class SavingAccountDAOTest {

    private static Connection connection;
    private int idStart;

    public SavingAccountDAOTest() {
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

//    @Before
//    public void setUp() {
//        try {
//            DBconnection dbConnection = new DBconnection();
//            this.connection = dbConnection.getConnect();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }
//
//    @After
//    public void tearDown() {
//        String deleteSavingAccount = "DELETE FROM savingaccount WHERE id > ?;";
//        try {
//            System.out.println(idStart);
//            PreparedStatement pre = connection.prepareStatement(deleteSavingAccount);
//            pre.setString(1, Integer.toString(idStart));
//            pre.executeUpdate();
//           //  TODO review the generated test code and remove the default call to fail.
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }
    /**
     * Test of addSavingAccount method, of class SavingAccountDAO.
     */
    @Test
    public void testAddSavingAccount() {
        System.out.println("addSavingAccount");

        SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
        BankAccountGenID bag = new BankAccountGenID();
        this.idStart = bag.lastSavingAccount;
        Customer customer = new Customer(1, "abc", "abc", "11111", "11111");
        SavingAccount sa;
        sa = new SavingAccount(1, "100001", 12312321, 2, "1", 1, new Date(), 10000);
        savingAccountDAO.addSavingAccount(sa);
        int idNew = sa.getId();

        String getSavingAccount = "SELECT * FROM savingaccount WHERE id = ?;";
        try {
            DateTimeFomater dtf = new DateTimeFomater();
            PreparedStatement pre = connection.prepareStatement(getSavingAccount);
            pre.setString(1, Integer.toString(idNew));
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                assertEquals(rs.getInt(1), idNew);
                assertEquals(rs.getDouble(3), 10000, 0.001);
                assertEquals(rs.getDouble(4), 8.7, 0.001);
                assertEquals(rs.getInt(5), 2);
                assertEquals(rs.getInt(6), 1);
                assertEquals(rs.getString(7), "Deposite");
            }

            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex) {
            fail("Got exception");
        }

    }

    /**
     * Test of getSavingAccountByIdCard method, of class SavingAccountDAO.
     */
}

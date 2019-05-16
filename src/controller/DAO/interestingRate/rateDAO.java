/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO.interestingRate;

import controller.connection.DBconnection;
import controller.DAO.CustomerDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang Thái
 */
public class rateDAO {

    private Connection connection;

    /**
     *
     */
    public int getCurrentNumberRate() {
        int kq = 0;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String strSQL = "SELECT COUNT(`id`) FROM `interestrate` WHERE 1=1 ";

            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                kq = rs.getInt(1);
            }
            System.out.println("" + kq);
            return kq;

        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return -1;

        }

    }

    public float getRate(String month, int idrate) {
        float kq = -1;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String strSQL = "SELECT `" + month + "` FROM `interestrate` WHERE `id`= '" + idrate + "'  ";

            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                kq = rs.getFloat(month);
            }
            return kq;

        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return kq;

        }
    }

    public boolean changeRate(double rate0, double rate1, double rate3, double rate6, double rate9, double rate12, double rate18, double rate24, double rate36, String date) {
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            boolean rs = false;
            String strSQL = "INSERT INTO `interestrate` (m0,m1,m3,m6,m9,m12,m18,m24,m36,created_at)\n"
                    + "VALUES ('" + rate0 + "','" + rate1 + "','" + rate3 + "','" + rate6 + "','" + rate9 + "','" + rate12 + "','" + rate18 + "','" + rate24 + "','" + rate36 + "','" + date + "'); ";
            System.out.println("" + strSQL);
            Statement comm = connection.createStatement();
            rs = (comm.executeUpdate(strSQL) > 0);
            return true;

        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;

        }
    }

    public String getDate(int id) {
        Date date = new Date();
        String kq = "";
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT `created_at` FROM `interestrate` WHERE `id`='" + id + "'";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            while (rs.next()) {
                kq = rs.getString("created_at");
            }
            return kq;
        } catch (Exception e) {
            Logger.getLogger(rateDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public Date getAccountDate(int id) {
        Date date = new Date();
        Date kq = null;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT `created_at` FROM `savingaccount` WHERE `id`='" + id + "'";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            while (rs.next()) {
                kq = rs.getDate("created_at");
            }
            return kq;
        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public int getMonth(int id) {
        int kq = -1;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT EXTRACT(MONTH FROM '" + getAccountDate(id) + "')";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            while (rs.next()) {
                kq = rs.getInt(1);
            }
            return kq;
        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public int getYear(int id) {
        int kq = -1;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT EXTRACT(Year FROM '" + getAccountDate(id) + "')";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            while (rs.next()) {
                kq = rs.getInt(1);
            }
            return kq;
        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public boolean setDate(Date date) {
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "UPDATE `interestrate` SET `created_at`='" + date.toString() + "' WHERE `id`='1'";
            System.out.println("" + query);
            Statement comm = connection.createStatement();
            int rs = comm.executeUpdate(query);
            return true;
        } catch (Exception e) {
            Logger.getLogger(rateDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

}

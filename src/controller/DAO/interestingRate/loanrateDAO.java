/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO.interestingRate;

import controller.connection.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang Thái
 */
public class loanrateDAO {

    private Connection connection;

    public int getCurrentNumberRate() {
        int kq = 0;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String strSQL = "SELECT COUNT(`id`) FROM `loanrate` WHERE 1=1 ";

            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                kq = rs.getInt(1);
            }
            System.out.println("" + kq);
            return kq;

        } catch (Exception e) {
            System.out.println("" + e);
            return -1;

        }

    }

    public float getRate(String month, int idrate) {
        float kq = -1;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String strSQL = "SELECT `" + month + "` FROM `loanrate` WHERE `id`= '" + idrate + "'  ";

            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                kq = rs.getFloat(month);
            }
            return kq;

        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            return kq;

        }
    }

    public boolean changeRate(double rate0, double rate1, double rate3, String date) {
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            boolean rs = false;
            String strSQL = "INSERT INTO `loanrate` (6month,12month,36month,created_at)\n"
                    + "VALUES ('" + rate0 + "','" + rate1 + "','" + rate3 + "','" + date + "'); ";
            System.out.println("" + strSQL);
            Statement comm = connection.createStatement();
            rs = (comm.executeUpdate(strSQL) > 0);
            return true;

        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;

        }
    }

    public Date getDate(int id) {
        Date date = new Date();
        Date kq = null;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT `created_at` FROM `loanrate` WHERE `id`='" + id + "'";
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

    public Date getAccountDate(int id) {
        Date date = new Date();
        Date kq = null;
        try {
            DBconnection dbConnection = new DBconnection();
            connection = dbConnection.getConnect();
            String query = "SELECT `created_at` FROM `loanaccount` WHERE `id`='" + id + "'";
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
            String query = "UPDATE `loanrate` SET `created_at`='" + date.toString() + "' WHERE `id`='1'";
            System.out.println("" + query);
            Statement comm = connection.createStatement();
            int rs = comm.executeUpdate(query);
            return true;
        } catch (Exception e) {
            Logger.getLogger(loanrateDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

}

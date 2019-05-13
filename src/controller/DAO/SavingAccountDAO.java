/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import Model.SavingAccount;
import controller.common.DateTimeFomater;
import controller.connection.DBconnection;
import Model.Customer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 * @author hailo
 */
public class SavingAccountDAO {

    private Connection connection;

    public SavingAccountDAO() {
        DBconnection dbConnection = new DBconnection();
        this.connection = dbConnection.getConnect();
    }

    public double sumCash() {
        double kq = -1;
        try {
            String query = "SELECT SUM(cash) FROM `savingaccount`";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            while (rs.next()) {
                kq = rs.getDouble("SUM(cash)");
            }
            System.out.println("" + kq);
        } catch (Exception e) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return kq;
    }

    public boolean addSavingAccount(SavingAccount account) {
        DateTimeFomater dtf = new DateTimeFomater();

        try {
            String addSavingAccount = "INSERT INTO `savingaccount` ( `id_rate`, `number`, `cash`, `term`,`idcustomer` ,`kind`, `date`, `iswithdrawned`) VALUES ( ?,?, ?, ?, ?, ?, ?,?);";
            PreparedStatement pre = connection.prepareStatement(addSavingAccount);
            pre.setString(2, account.getNumber());
            pre.setDouble(3, account.getCash());
            pre.setDouble(1, account.getId_rate());
            pre.setInt(5,account.getCustomer());
            pre.setInt(4, account.getTerm());
            pre.setString(6, account.getKind());
            pre.setString(7, dtf.convertDateToString(account.getDate()));
            pre.setInt(8, account.getIsWithdrawned());

            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

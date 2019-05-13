/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.common;

import controller.connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailo
 */
public class BankAccountGenID {

    public int lastSavingAccount;
    public int lastCustomerId;
    private boolean checked;

    public BankAccountGenID()  {
        init();
    }

    private void init()  {
        try {
            DBconnection dbConnection = new DBconnection();
            Connection connection = dbConnection.getConnect();
            String getLastSavingAccount = "SELECT * FROM savingaccount;";
            String getLastCustomer = "SELECT * FROM customer;";
            PreparedStatement pre2 = connection.prepareStatement(getLastSavingAccount);
            PreparedStatement pre3 = connection.prepareStatement(getLastCustomer);
            ResultSet rs2 = pre2.executeQuery();
            ResultSet rs3 = pre3.executeQuery();
            while (rs2.next()) {
                lastSavingAccount = rs2.getInt(1);
            }
            while (rs3.next()) {
                lastCustomerId = rs3.getInt(1);
            }
            checked = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getNewCustomerId() {
        if (checked == false) {
            init();
        }
        checked = false;
        return lastCustomerId + 1;
    }

    public int getNewSavingAccountId()  {
        if (checked == false) {
            init();
        }
        checked = false;
        return lastSavingAccount + 1;
    }

    @Override
    public String toString() {
        return "BankAccountGenID{" + "lastSavingAccount=" + lastSavingAccount + ", lastCustomerId=" + lastCustomerId + ", checked=" + checked + '}';
    }

}

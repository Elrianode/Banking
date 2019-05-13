package controller.DAO;

import Model.Customer;
import Model.SavingAccount;
import controller.DAO.SavingAccountDAO;
import controller.connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.*;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO() {
        DBconnection dbConnection = new DBconnection();
        this.connection = dbConnection.getConnect();
    }

    public List<Customer> getListCustomer() {
        List<Customer> lstCustomer = new ArrayList<>();
        try {
            String strSQL = "SELECT id, name, address, idcard, phone FROM customer WHERE 1=1";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            Customer customer;
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFullName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setIdCard(rs.getString("idcard"));
                customer.setPhoneNumber(rs.getString("phone"));
                lstCustomer.add(customer);
            }
            return lstCustomer;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Customer getCustomerByGeneratedId(int id) {
        try {
            String query = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setInt(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(5), rs.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public SavingAccount getSavingAccount(int id) {
        try {
            String query = "SELECT * FROM `savingaccount` INNER JOIN `interestrate` WHERE `idcustomer` = '" + id + "'";
            Statement comm = connection.createStatement();
            ResultSet rs = comm.executeQuery(query);
            System.out.println("" + query);
            SavingAccount SA = new SavingAccount();
            while (rs.next()) {
                SA.setId_rate(rs.getInt("id_rate"));
                SA.setCash(rs.getFloat("cash"));
                SA.setIsWithdrawned(rs.getInt("cash"));
            }
            return SA;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

    public Customer getCustomerByIdCard(String cardId) {
        try {
            String query = "SELECT * FROM account WHERE idcard = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setString(1, cardId);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(5), rs.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public boolean addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer( name, address, idcard, phone) VALUES = (?,?,?,?)";
            PreparedStatement sttm = connection.prepareStatement(query);
//            sttm.setInt(1, customer.getId());
            sttm.setString(1, customer.getFullName());
            sttm.setString(2, customer.getAddress());
            sttm.setString(3, customer.getIdCard());
            sttm.setString(4, customer.getPhoneNumber());
            int rowAffected = sttm.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean deleteCustomer(Customer customer) {
        try {
            String query = "DELETE FROM customer WHERE id = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setInt(1, customer.getId());
            int rowAffected = sttm.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        try {
            String query = "UPDATE customer SET name = ?, address = ?, idcard = ?, phone = ? WHERE id = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setString(1, customer.getFullName());
            sttm.setString(2, customer.getAddress());
            sttm.setString(3, customer.getIdCard());
            sttm.setString(4, customer.getPhoneNumber());
            sttm.setInt(5, customer.getId());
            int rowAffected = sttm.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}

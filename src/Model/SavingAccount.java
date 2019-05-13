/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author hailo
 */
public class SavingAccount {

    private int id;
    private int id_rate;
    private String number;
    private double cash;
    private int term;
    private String kind;
    private int customer;
    private Date date;
    private int isWithdrawned;

    public SavingAccount( int id_rate, String number, double cash, int term, String kind, int customer, Date date, int isWithdrawned) {
        this.id_rate = id_rate;
        this.number = number;
        this.cash = cash;
        this.term = term;
        this.kind = kind;
        this.customer = customer;
        this.date = date;
        this.isWithdrawned = isWithdrawned;
    }

    public SavingAccount() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rate() {
        return id_rate;
    }

    public void setId_rate(int id_rate) {
        this.id_rate = id_rate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIsWithdrawned() {
        return isWithdrawned;
    }

    public void setIsWithdrawned(int isWithdrawned) {
        this.isWithdrawned = isWithdrawned;
    }
    

    public String autoGenNumber(int id) {
        String numberFomartted = String.format("HN%06d", id);
        return numberFomartted;
    }

}

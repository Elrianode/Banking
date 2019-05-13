package Model;

import Model.Account;

public class Customer {

    private int id;
    public String fullName;
    public String address;
    public String phoneNumber;
    String idCard;

    public Customer(int id, String fullName, String address, String phoneNumber, String idCard) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }
@Override
    public String toString() {
        return "Customer{" + "id=" + id + ",fullName=" + fullName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", idCard=" + idCard + '}';
    }
    
}

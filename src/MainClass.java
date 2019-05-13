
import view.register.LoginFrm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quang Thái
 */
public class MainClass {

    public static void main(String[] args) {
//        LoginFrm loginfrm = new LoginFrm();
//        loginfrm.setVisible(true);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("" + utilDate);
        System.out.println("" + sqlDate);
    }
}

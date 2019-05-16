
import controller.DAO.interestingRate.loanrateDAO;
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
        loanrateDAO newDao = new loanrateDAO();
        System.out.println("" + newDao.getMonth(1));
        int n = 38 / 12;
        System.out.println("" + n);
    }
}

package Model;

import controller.connection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterestRate {
    public double RATE_0_MONTHS;
    public double RATE_1_MONTHS;
    public double RATE_3_MONTHS;
    public double RATE_6_MONTHS;
    public double RATE_9_MONTHS;
    public double RATE_12_MONTHS;
    public double RATE_18_MONTHS;
    public double RATE_24_MONTHS;
    public double RATE_36_MONTHS;

    public InterestRate() {
        getRate();
    }

    void getRate() {
        try {
            Connection connection = new DBconnection().getConnect();
            String getRate = "SELECT * FROM interestrate WHERE id = ? ;";
            PreparedStatement pre = connection.prepareStatement(getRate);
            pre.setInt(1, 1);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                this.RATE_0_MONTHS = rs.getDouble(3);
                this.RATE_1_MONTHS = rs.getDouble(4);
                this.RATE_3_MONTHS = rs.getDouble(5);
                this.RATE_6_MONTHS = rs.getDouble(6);
                this.RATE_9_MONTHS = rs.getDouble(7);
                this.RATE_12_MONTHS = rs.getDouble(8);
                this.RATE_18_MONTHS = rs.getDouble(9);
                this.RATE_24_MONTHS = rs.getDouble(10);
                this.RATE_36_MONTHS = rs.getDouble(11);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getRATE_0_MONTHS() {
        return RATE_0_MONTHS;
    }

    public double getRATE_1_MONTHS() {
        return RATE_1_MONTHS;
    }

    public double getRATE_3_MONTHS() {
        return RATE_3_MONTHS;
    }

    public double getRATE_6_MONTHS() {
        return RATE_6_MONTHS;
    }

    public double getRATE_9_MONTHS() {
        return RATE_9_MONTHS;
    }

    public double getRATE_12_MONTHS() {
        return RATE_12_MONTHS;
    }

    public double getRATE_18_MONTHS() {
        return RATE_18_MONTHS;
    }

    public double getRATE_24_MONTHS() {
        return RATE_24_MONTHS;
    }

    public double getRATE_36_MONTHS() {
        return RATE_36_MONTHS;
    }
    

    public double getRateByMonth(int term, Date month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String monthSearch = sdf.format(month);
        try {
            Connection connection = new DBconnection().getConnect();
            String getRate = "SELECT * FROM interestrate WHERE date = ? ;";
            PreparedStatement pre = connection.prepareStatement(getRate);
            pre.setString(1, monthSearch);
            ResultSet rs = pre.executeQuery();
            int col=0;
            switch (term) {
                case 0:
                    col = 3;
                    break;
                case 1:
                    col = 4;
                    break;
                case 2:
                    col = 4;
                    break;
                case 3:
                    col = 5;
                    break;
                case 4:
                    col = 5;
                    break;
                case 5:
                    col = 5;
                    break;
                case 6:
                    col = 6;
                    break;
                case 7:
                    col = 6;
                    break;
                case 8:
                    col = 6;
                    break;
                case 9:
                    col = 7;
                    break;
                case 12:
                    col = 8;
                    break;
                case 18:
                    col = 9;
                    break;
                case 24:
                    col = 10;
                    break;
                case 36:
                    col = 11;
                    break;
            }
            if (col == 0)return 0;
            double rate = 0;
            while (rs.next()) {
                rate = rs.getDouble(col);
            }
            return rate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

package controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static final String JDBC_DRIVER
            = "com.mysql.jdbc.Driver";
    private static final String DATABASE_PATH
            = "jdbc:mysql://localhost/banking3?characterEncoding=utf-8&useUnicode=true";

    /**
     * Kết nối cơ sở dữ liệu
     *
     * @return {@link Connection}
     */
    public static Connection getConnect() {
        Connection conn = null;

        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_PATH,
                    "root", "");
         //   System.out.println("kết nối Database");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Lỗi khi kết nối DB: "
                    + ex.toString());
        }
        return conn;
    }

    public static void main(String[] args) {
        DBconnection.getConnect();
    }

}

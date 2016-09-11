package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class DB {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String ip = "10.0.87.2";
    private static int port = 3306;
    private static String db = "spex3";
    private static Object[] urlData = {ip, port, db};
    private static String url = String.format("jdbc:mysql://%1$s:%2$s/%3$s", urlData);
    private static String user = "test";
    private static String password = "password";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

}

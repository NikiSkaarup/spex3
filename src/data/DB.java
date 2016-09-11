package data;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class DB {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String ip = "10.0.87.2";
    private static String db = "spex3";
    private static String url = "jdbc:mysql://" + ip + ":3306/" + db;
    private static String user = "test";
    private static String password = "password";

    public static Connection getConnection() {
        Connection conn = null;
        try {
//            Context context = new InitialContext();
//            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setServerName(ip);
            dataSource.setDatabaseName(db);
//            dataSource.setUrl(url);
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}

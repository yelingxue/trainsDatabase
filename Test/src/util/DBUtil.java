package util;

import java.sql.*;

public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 1433;
    static String database = "db_train";
    static String loginName = "201901";
    static String password = "201901";
    static{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:sqlserver://%s:%d;DatabaseName=%s", ip, port, database);
        return DriverManager.getConnection(url, loginName, password);
    }
}

package com.koreait.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/java?severTimezone=Asia/Seoul";
        String user = "root";
        String password = "1234";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}

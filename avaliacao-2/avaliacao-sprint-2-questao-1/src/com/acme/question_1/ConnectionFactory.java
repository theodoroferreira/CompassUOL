package com.acme.question_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private final String URL = "jdbc:mysql://localhost:3306/questao_1?useTimezone=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

package com.LaCuponera.www.model.Login;

import java.sql.*;

public class LoginModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cuponerasv";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public String authenticateUser(String email, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT role_id FROM users WHERE email = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("role_id");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Autenticación fallida
    }
}
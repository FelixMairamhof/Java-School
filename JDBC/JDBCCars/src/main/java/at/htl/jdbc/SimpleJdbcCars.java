package at.htl.jdbc;

import java.sql.*;

public class SimpleJdbcCars {
    public static void main(String[] args) {
        doUpdate();
        doSelect();
    }

    private static void doSelect() {
        String url = "jdbc:mysql://localhost:3306/cars";
        try {
            Connection conn = DriverManager.getConnection(url, "root", "password");
            String st = "SELECT * FROM cars WHERE id < ?";
            PreparedStatement ps = conn.prepareStatement(st);
            ps.setInt(1, 3);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String name = result.getString(2);
                System.out.println(name);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doUpdate() {
        String url = "jdbc:mysql://localhost:3306/cars";
        try {
            Connection conn = DriverManager.getConnection(url, "root", "password");
            String st = "UPDATE cars SET price = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(st);
            ps.setDouble(1, 12345);
            ps.setInt(2, 1);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

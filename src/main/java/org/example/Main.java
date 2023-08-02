package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    static String dsn = "jdbc:oracle:thin:@localhost:1521:xe";
    static String user = "system";
    static String password = "oracle";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(dsn, user, password); Statement stmt = con.createStatement()) {
            Class.forName(dsn);

            ResultSet rs = stmt.executeQuery("select * from emp");

            while (rs.next()) {
                System.out.printf("%-10s %-10s %-10s%n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
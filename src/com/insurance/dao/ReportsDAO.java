package com.insurance.dao;

import com.insurance.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportsDAO {
    public static void policiesDueForRenewal() {
        String sql = "SELECT * FROM policy WHERE end_date <= CURDATE() + INTERVAL 30 DAY";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== Policies Due for Renewal in Next 30 Days ===");
            while (rs.next()) {
                System.out.println("Policy ID: " + rs.getString("policy_id"));
                System.out.println("Client ID: " + rs.getString("client_id"));
                System.out.println("End Date: " + rs.getDate("end_date"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error running report: " + e.getMessage());
        }
    }

    // Add more reports later
}

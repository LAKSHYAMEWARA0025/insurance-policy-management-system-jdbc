package com.insurance.dao;

import com.insurance.db.DBConnection;
import com.insurance.model.PolicyType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PolicyTypeDAO {
    public static void viewAllPolicyTypes() {
        String sql = "SELECT * FROM policy_type";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== All Policy Types ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("policy_type_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Coverage: " + rs.getString("coverage_details"));
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error retrieving policy types: " + e.getMessage());
        }
    }
}

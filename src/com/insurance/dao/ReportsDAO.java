package com.insurance.dao;

import com.insurance.db.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class ReportsDAO {
    public static void getRenewalsWithinDays() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days for upcoming renewals: ");
        int days = sc.nextInt();

        String sql = """
        SELECT 
            p.policy_id,
            c.name AS client_name,
            pt.name AS policy_type,
            p.end_date,
            DATEDIFF(p.end_date, CURDATE()) AS days_left
        FROM 
            policy p
        JOIN 
            client c ON p.client_id = c.client_id
        JOIN 
            policy_type pt ON p.policy_type_id = pt.policy_type_id
        WHERE 
            DATEDIFF(p.end_date, CURDATE()) BETWEEN 0 AND ?
        ORDER BY 
            p.end_date ASC;
    """;

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setInt(1, days);
            ResultSet rs = pstmt.executeQuery();

            System.out.printf("%-10s %-20s %-20s %-15s %-10s%n",
                    "PolicyID", "Client Name", "Policy Type", "End Date", "Days Left");

            while (rs.next()) {
                System.out.printf("%-10s %-20s %-20s %-15s %-10d%n",
                        rs.getString("policy_id"),
                        rs.getString("client_name"),
                        rs.getString("policy_type"),
                        rs.getDate("end_date"),
                        rs.getInt("days_left")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching renewals: " + e.getMessage());
        }
    }

    public static void outstandingPremiumAmount(){
        String query="SELECT \n" +
                "    c.client_id,\n" +
                "    c.username,\n" +
                "    c.phoneNo,\n" +
                "    SUM(pr.amount) AS total_outstanding_amount\n" +
                "FROM \n" +
                "    premium pr\n" +
                "JOIN \n" +
                "    policy p ON pr.policy_id = p.policy_id\n" +
                "JOIN \n" +
                "    client c ON p.client_id = c.client_id\n" +
                "WHERE \n" +
                "    pr.status != 'Paid'\n" +
                "GROUP BY \n" +
                "    c.client_id, c.username, c.phoneNo\n" +
                "ORDER BY \n" +
                "    total_outstanding_amount DESC;\n";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n=== Total Outstanding premium amount ===");
            while (rs.next()) {
                System.out.println("Client_id: " + rs.getString("client_id"));
                System.out.println("Name: "+rs.getString("username"));
                System.out.println("Contact_Number: "+rs.getString("phoneNo"));
                System.out.println("total_outstanding_amount: "+rs.getInt("total_outstanding_amount"));
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error retrieving policy types: " + e.getMessage());
        }
    }

    // Add more reports later
}

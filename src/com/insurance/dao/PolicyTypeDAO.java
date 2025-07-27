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
    //claim approval rates by policy type
    public static void viewClaimApprovalRates(){
        String query="SELECT \n" +
                "    pt.name AS policy_type,\n" +
                "    COUNT(c.claim_id) AS total_claims,\n" +
                "    SUM(CASE WHEN latest_status.status = 'Approved' THEN 1 ELSE 0 END) AS approved_claims,\n" +
                "    ROUND(SUM(CASE WHEN latest_status.status = 'Approved' THEN 1 ELSE 0 END) * 100.0 / COUNT(c.claim_id), 2) AS approval_rate_percentage\n" +
                "FROM \n" +
                "    claim c\n" +
                "JOIN \n" +
                "    (\n" +
                "        SELECT cs1.claim_id, cs1.status\n" +
                "        FROM claim_status cs1\n" +
                "        JOIN (\n" +
                "            SELECT claim_id, MAX(date) AS latest_date\n" +
                "            FROM claim_status\n" +
                "            GROUP BY claim_id\n" +
                "        ) cs2 ON cs1.claim_id = cs2.claim_id AND cs1.date = cs2.latest_date\n" +
                "    ) latest_status ON c.claim_id = latest_status.claim_id\n" +
                "JOIN \n" +
                "    policy p ON c.policy_id = p.policy_id\n" +
                "JOIN \n" +
                "    policy_type pt ON p.policy_type_id = pt.policy_type_id\n" +
                "GROUP BY \n" +
                "    pt.name;\n";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n=== Claim Approval Rates ===");
            while (rs.next()) {
                System.out.println("policy_type: " + rs.getString("policy_type"));
                System.out.println("total_claims: " + rs.getInt("total_claims"));
                System.out.println("approved_claims: " + rs.getInt("approved_claims"));
                System.out.println("approval_rate: " + rs.getDouble("approval_rate_percentage"));
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error retrieving policy types: " + e.getMessage());
        }
    }
    public static void revenueByCategory(){
        String query="SELECT \n" +
                "    pt.category AS policy_category,\n" +
                "    SUM(pr.amount) AS total_revenue\n" +
                "FROM \n" +
                "    premium pr\n" +
                "JOIN \n" +
                "    policy p ON pr.policy_id = p.policy_id\n" +
                "JOIN \n" +
                "    policy_type pt ON p.policy_type_id = pt.policy_type_id\n" +
                "WHERE \n" +
                "    pr.status = 'Paid'\n" +
                "GROUP BY \n" +
                "    pt.category;\n";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n=== Revenue by Policy Category ===");
            while (rs.next()) {
                System.out.println("policy_category: " + rs.getString("policy_category"));
                System.out.println("total_revenue: " + rs.getInt("total_revenue"));
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error retrieving policy types: " + e.getMessage());
        }
    }
    public static void avgClaimPayout(){
        String query="SELECT \n" +
                "    ROUND(AVG(p.amount), 2) AS average_claim_payout\n" +
                "FROM \n" +
                "    payout p;\n";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n=== Average claim payout ===");
            while (rs.next()) {
                System.out.println("average_claim_payout: " + rs.getString("average_claim_payout"));
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error retrieving policy types: " + e.getMessage());
        }
    }
}

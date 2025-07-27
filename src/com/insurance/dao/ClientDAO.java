package com.insurance.dao;

import com.insurance.db.DBConnection;
import com.insurance.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {
    public void addClient(Client client) {
        String sql = "INSERT INTO Client (client_id, username, email, dob, phoneNo, address) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, client.getClientId());
            ps.setString(2, client.getUsername());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getDob());
            ps.setString(5, client.getPhoneNo());
            ps.setString(6, client.getAddress());

            ps.executeUpdate();
            System.out.println("✅ Client added successfully.");
        } catch (SQLException e) {
            System.out.println("❌ Failed to add client: " + e.getMessage());
        }
    }
}

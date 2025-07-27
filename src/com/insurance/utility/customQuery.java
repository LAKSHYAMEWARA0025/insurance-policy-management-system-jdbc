package com.insurance.utility;

import java.sql.*;
import java.util.Scanner;
import com.insurance.db.DBConnection;

public class customQuery {

    public static void runCustomQuery() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your SQL query (SELECT only):");
        String sql = sc.nextLine();

        if (!sql.trim().toLowerCase().startsWith("select")) {
            System.out.println("Only SELECT queries are allowed.");
            return;
        }

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            // Column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(meta.getColumnName(i) + "\t");
            }
            System.out.println();

            // Rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    int type = meta.getColumnType(i);
                    Object value;

                    switch (type) {
                        case Types.INTEGER, Types.SMALLINT -> value = rs.getInt(i);
                        case Types.DOUBLE, Types.FLOAT, Types.DECIMAL, Types.NUMERIC -> value = rs.getDouble(i);
                        case Types.DATE -> value = rs.getDate(i);
                        case Types.TIMESTAMP -> value = rs.getTimestamp(i);
                        case Types.BOOLEAN -> value = rs.getBoolean(i);
                        default -> value = rs.getString(i);
                    }

                    System.out.print((value != null ? value : "NULL") + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}

package com.insurance;

import com.insurance.dao.PolicyTypeDAO;
import com.insurance.dao.ReportsDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Insurance Management System =====");
            System.out.println("1. Add Client");
            System.out.println("2. View Policy Types");
            System.out.println("3. Submit Claim");
            System.out.println("4. Policies due for renewal");
            System.out.println("5. Revenue by Policy Category");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ClientUI.addClient(); // A method that handles client input
                    break;
                case 2:
                    PolicyTypeDAO.viewAllPolicyTypes();
                    break;
//                case 3:
//                    ClaimUI.submitClaim();
//                    break;
                case 4:
                    ReportsDAO.policiesDueForRenewal();
                    break;
//                case 5:
//                    ReportsDAO.revenueByCategory();
//                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }
}

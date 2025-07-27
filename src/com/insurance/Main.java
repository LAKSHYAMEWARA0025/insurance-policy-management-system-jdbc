package com.insurance;

import com.insurance.dao.PolicyTypeDAO;
import com.insurance.dao.ReportsDAO;
import com.insurance.utility.customQuery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Insurance Management System =====");
            System.out.println("1. View Different Policy Types");
            System.out.println("2. View revenue by each category");
            System.out.println("3. Policies due for renewal in next X days");
            System.out.println("4. View claim approval rates by policy type");
            System.out.println("5. View Outstanding premium amounts by Customer");
            System.out.println("6. Average claim payout per incident");
            System.out.println("7. Run your own select custom query.");
            System.out.println("8. Exit!");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PolicyTypeDAO.viewAllPolicyTypes();
                    break;
                case 2:
                    PolicyTypeDAO.revenueByCategory();
                    break;
                case 3:
                  ReportsDAO.getRenewalsWithinDays();
                case 4:
                    PolicyTypeDAO.viewClaimApprovalRates();
                    break;
                case 5:
                    ReportsDAO.outstandingPremiumAmount();
                    break;
                case 6:
                    PolicyTypeDAO.avgClaimPayout();
                    break;
                case 7:
                    customQuery.runCustomQuery();
                    break;
                case 8:
                    System.out.println("Thank you for choosing and working on our system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
}

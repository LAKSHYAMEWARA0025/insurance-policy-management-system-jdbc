package com.insurance;

import com.insurance.dao.ClientDAO;
import com.insurance.model.Client;

import java.util.Scanner;

public class ClientUI {
    public static void addClient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Client ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        Client client = new Client(id, name, email, dob, phone, address);
        new ClientDAO().addClient(client);
    }
}

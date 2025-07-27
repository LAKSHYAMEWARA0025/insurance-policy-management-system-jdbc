# 🛡️ Insurance Policy Management System (JDBC-Based)

This is a console-based **Insurance Policy Management System** built in **Java using JDBC** and **MySQL**. It allows management of clients, policies, premiums, claims, claim statuses, renewals, payouts, and custom reporting.

---

## 📌 Features Implemented

1. View different policy types
2. View revenue by each policy category
3. View policies due for renewal in next X days
4. View claim approval rates by policy type
5. View outstanding premium amounts by customer
6. View average claim payout per incident
7. Run your own custom SQL `SELECT` query from console
8. Exit program

---

## 🧱 Folder Structure

InsurancePolicyManagementSystem/
├── .idea/ # IntelliJ config folder
├── out/ # Compiled .class files
├── src/
│ └── com/
│ └── insurance/
│ ├── dao/
│ │ ├── ClientDAO.java
│ │ ├── PolicyTypeDAO.java
│ │ └── ReportsDAO.java
│ ├── db/
│ │ └── DBConnection.java
│ ├── model/
│ │ ├── Client.java
│ │ └── PolicyType.java
│ ├── utility/
│ │ └── QueryRunner.java
│ ├── ClientUI.java
│ └── Main.java
├── resources/
│ └── schema.sql # SQL file to create & populate database
├── lib/
│ └── mysql-connector-java-8.0.xx.jar
├── .gitignore
└── InsuranceManagementSystem.iml



## 🧰 Tech Stack

- Java 17+
- JDBC (Java Database Connectivity)
- MySQL 8+
- IntelliJ IDEA
- No Maven/Gradle used

---

## 🛠️ Setup Instructions (for Other Users)

> ⚠️ Ensure you have Java JDK and MySQL installed before proceeding.

### ✅ Step 1: Set up the MySQL Database

1. Open MySQL Workbench or terminal.
2. Run the following script to **create the database and tables**:

sql
-- Create database
CREATE DATABASE IF NOT EXISTS insurance_db;
USE insurance_db;

-- Create tables
CREATE TABLE client (
    client_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(50),
    address TEXT
);

CREATE TABLE policy_type (
    policy_type_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    category VARCHAR(50),
    grace_period int
);

CREATE TABLE policy (
    policy_id VARCHAR(20) PRIMARY KEY,
    client_id VARCHAR(20),
    policy_type_id VARCHAR(20),
    start_date DATE,
    end_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (policy_type_id) REFERENCES policy_type(policy_type_id)
);

CREATE TABLE premium (
    premium_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(20),
    due_date DATE,
    amount DECIMAL(10,2),
    status VARCHAR(20),
    FOREIGN KEY (policy_id) REFERENCES policy(policy_id)
);

CREATE TABLE claim (
    claim_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(20),
    client_id VARCHAR(20),
    incident_details TEXT,
    claim_date DATE,
    FOREIGN KEY (policy_id) REFERENCES policy(policy_id),
    FOREIGN KEY (client_id) REFERENCES client(client_id)
);

CREATE TABLE claim_status (
    claim_status_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20),
    status VARCHAR(20),
    updated_on DATE,
    FOREIGN KEY (claim_id) REFERENCES claim(claim_id)
);

CREATE TABLE payout (
    payout_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20),
    amount_paid DECIMAL(10,2),
    payment_date DATE,
    FOREIGN KEY (claim_id) REFERENCES claim(claim_id)
);

CREATE TABLE endorsement (
    endorsement_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(20),
    change_description TEXT,
    change_date DATE,
    FOREIGN KEY (policy_id) REFERENCES policy(policy_id)
);


** Change your Database credentials **
(URL,Username,Password) in db->DBConnection.java

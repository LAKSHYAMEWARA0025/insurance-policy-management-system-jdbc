# 🛡️ Insurance Policy Management System (JDBC-Based)

This is a console-based Insurance Policy Management System built in Java using JDBC and MySQL. It allows management of clients, policies, premiums, claims, claim statuses, renewals, payouts, and custom reporting.

📌 Features Implemented

1.View different policy types.

2.View revenue by each policy category.

3.View policies due for renewal in next X days (X will be provided by the user).

4.View claim approval rates by policy type.

5.View outstanding premium amounts by customer.

6.View average claim payout per incident.

7.Run your own custom SQL SELECT query from console.

8.Exit program!.

# Folder Structure
InsurancePolicyManagementSystem/

├── .idea/                          # IntelliJ IDEA configuration files

├── out/                           # Compiled .class files and generated artifacts

│   └── artifacts/

│       └── InsuranceManagementSystem_jar/

│           └── InsuranceManagementSystem.jar   # Runnable jar file


├── src/                           # Java source code

│   └── com/

│       └── insurance/

│           ├── dao/               # Data Access Object classes

│           │   ├── ClientDAO.java

│           │   ├── PolicyTypeDAO.java

│           │   └── ReportsDAO.java

│           ├── db/                # Database connection utility

│           │   └── DBConnection.java

│           ├── model/             # Model classes

│           │   ├── Client.java

│           │   └── PolicyType.java

│           ├── utility/           # Utility classes

│           │   └── QueryRunner.java

│           ├── ClientUI.java      # Console UI class

│           └── Main.java          # Main class to run the program

├── resources/

│   └── schema.sql                 # SQL script to create and populate the database

│   └── db_config.properties                      ✅ Editable DB config

├── .gitignore

├── InsuranceManagementSystem.iml  # IntelliJ project file

└── README.md      

External Libraries



🧰 Tech Stack
❤Java 17+

❤JDBC (Java Database Connectivity)

❤MySQL 8+

❤IntelliJ IDEA

❤No Maven/Gradle used (manual jar management)

# 🛠️ Setup Instructions
### ⚠️ Ensure you have Java JDK and MySQL installed before proceeding.

## Step 1: Set up the MySQL Database
Open MySQL Workbench or your preferred MySQL terminal client.

Execute the SQL script contained in the resources/schema.sql file to create and populate the database with necessary tables and sample data.

### For example, in MySQL terminal:
source path/to/resources/schema.sql;
Note: The SQL script includes database, tables, and sample data creation. Refer to schema.sql for details.

## Step 2:The database configuration is now externalized in a db_config.properties file, so users can run the project without modifying any Java code.

Open the file: resources/db_config.properties

 After updating the properties file, just run the jar — no need to rebuild!

#### Update the database connection URL, username, and password according to your local MySQL setup.

## Step 3: Build and Run the Project
The runnable jar file is generated at:
out/artifacts/InsuranceManagementSystem_jar/InsuranceManagementSystem.jar

#### To run the jar file, open a terminal in the project root and execute:

java -jar out/artifacts/InsuranceManagementSystem_jar/InsuranceManagementSystem.jar
If your project requires the MySQL connector jar separately, make sure it’s in the classpath or included in the jar.

Thanks!

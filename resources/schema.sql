```sql -- Create database CREATE DATABASE IF NOT EXISTS insurance_db; USE insurance_db;

-- Create tables CREATE TABLE client ( client_id VARCHAR(20) PRIMARY KEY, name VARCHAR(50), contact_number VARCHAR(15), email VARCHAR(50), address TEXT );

CREATE TABLE policy_type ( policy_type_id VARCHAR(20) PRIMARY KEY, name VARCHAR(50), description TEXT, category VARCHAR(50), grace_period int );

CREATE TABLE policy ( policy_id VARCHAR(20) PRIMARY KEY, client_id VARCHAR(20), policy_type_id VARCHAR(20), start_date DATE, end_date DATE, status VARCHAR(20), FOREIGN KEY (client_id) REFERENCES client(client_id), FOREIGN KEY (policy_type_id) REFERENCES policy_type(policy_type_id) );

CREATE TABLE premium ( premium_id VARCHAR(20) PRIMARY KEY, policy_id VARCHAR(20), due_date DATE, amount DECIMAL(10,2), status VARCHAR(20), FOREIGN KEY (policy_id) REFERENCES policy(policy_id) );

CREATE TABLE claim ( claim_id VARCHAR(20) PRIMARY KEY, policy_id VARCHAR(20), client_id VARCHAR(20), incident_details TEXT, claim_date DATE, FOREIGN KEY (policy_id) REFERENCES policy(policy_id), FOREIGN KEY (client_id) REFERENCES client(client_id) );

CREATE TABLE claim_status ( claim_status_id VARCHAR(20) PRIMARY KEY, claim_id VARCHAR(20), status VARCHAR(20), updated_on DATE, FOREIGN KEY (claim_id) REFERENCES claim(claim_id) );

CREATE TABLE payout ( payout_id VARCHAR(20) PRIMARY KEY, claim_id VARCHAR(20), amount_paid DECIMAL(10,2), payment_date DATE, FOREIGN KEY (claim_id) REFERENCES claim(claim_id) );

CREATE TABLE endorsement ( endorsement_id VARCHAR(20) PRIMARY KEY, policy_id VARCHAR(20), change_description TEXT, change_date DATE, FOREIGN KEY (policy_id) REFERENCES policy(policy_id) );```
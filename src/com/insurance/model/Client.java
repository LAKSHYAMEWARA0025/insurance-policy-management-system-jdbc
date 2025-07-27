package com.insurance.model;

public class Client {
    private String clientId;
    private String username;
    private String email;
    private String dob;
    private String phoneNo;
    private String address;

    public Client(String clientId, String username, String email, String dob, String phoneNo, String address) {
        this.clientId = clientId;
        this.username = username;
        this.email = email;
        this.dob = dob;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    // Getters and setters...

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

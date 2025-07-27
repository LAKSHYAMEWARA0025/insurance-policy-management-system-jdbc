package com.insurance.model;

public class PolicyType {
    private String policyTypeId;
    private String name;
    private String category;
    private String coverageDetails;

    // Constructor
    public PolicyType(String policyTypeId, String name, String category, String coverageDetails) {
        this.policyTypeId = policyTypeId;
        this.name = name;
        this.category = category;
        this.coverageDetails = coverageDetails;
    }

    // Getters
    public String getPolicyTypeId() { return policyTypeId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getCoverageDetails() { return coverageDetails; }
}

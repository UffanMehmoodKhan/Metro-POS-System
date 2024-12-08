package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.BranchManager;

public class SuperAdminBranchManagerRequest {

    private String branchManagerName;
    private String branchManagerEmail;
    private String branchManagerPassword;
    private String branchManagerBranchCode;
    private double branchManagerSalary;

    public SuperAdminBranchManagerRequest() {
    }

    public SuperAdminBranchManagerRequest(String branchManagerName, String branchManagerEmail, String branchManagerPassword, String branchManagerBranchCode, double branchManagerSalary) {
        this.branchManagerName = branchManagerName;
        this.branchManagerEmail = branchManagerEmail;
        this.branchManagerPassword = branchManagerPassword;
        this.branchManagerBranchCode = branchManagerBranchCode;
        this.branchManagerSalary = branchManagerSalary;
    }

    // Getters and setters

    public String getBranchManagerName() {
        return branchManagerName;
    }

    public void setBranchManagerName(String branchManagerName) {
        this.branchManagerName = branchManagerName;
    }

    public String getBranchManagerEmail() {
        return branchManagerEmail;
    }

    public void setBranchManagerEmail(String branchManagerEmail) {
        this.branchManagerEmail = branchManagerEmail;
    }

    public String getBranchManagerPassword() {
        return branchManagerPassword;
    }

    public void setBranchManagerPassword(String branchManagerPassword) {
        this.branchManagerPassword = branchManagerPassword;
    }

    public String getBranchManagerBranchCode() {
        return branchManagerBranchCode;
    }

    public void setBranchManagerBranchCode(String branchManagerBranchCode) {
        this.branchManagerBranchCode = branchManagerBranchCode;
    }

    public double getBranchManagerSalary() {
        return branchManagerSalary;
    }

    public void setBranchManagerSalary(double branchManagerSalary) {
        this.branchManagerSalary = branchManagerSalary;
    }
}
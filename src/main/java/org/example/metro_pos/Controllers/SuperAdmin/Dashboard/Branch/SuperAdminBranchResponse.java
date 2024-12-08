package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

public class SuperAdminBranchResponse {

    private String branchCode;
    private String branchName;
    private String city;
    private String address;
    private String phone;
    private boolean active;
    private int numEmployees;
    private String managerName;
    private String managerEmail;
    private double managerSalary;

    public SuperAdminBranchResponse() {
    }

    public SuperAdminBranchResponse(String branchCode, String branchName, String city, String address, String phone, boolean active, int numEmployees, String managerName, String managerEmail, double managerSalary) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.active = active;
        this.numEmployees = numEmployees;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.managerSalary = managerSalary;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public double getManagerSalary() {
        return managerSalary;
    }

    public void setManagerSalary(double managerSalary) {
        this.managerSalary = managerSalary;
    }
}
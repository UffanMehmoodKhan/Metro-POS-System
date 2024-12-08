package org.example.metro_pos.Controllers.DataOperator.Dashboard;

public class DataOperatorBranchResponse {

    private String branchCode;
    private String branchName;
    private String city;
    private String address;
    private String phone;
    private int numEmployees;
    private boolean active;
    private String branchManagerName;
    private String branchManagerEmail;
    private double branchManagerSalary;

    public DataOperatorBranchResponse(){

    }

    public DataOperatorBranchResponse(String branchCode, String branchName, String city, String address, String phone, int numEmployees, boolean active, String branchManagerName, String branchManagerEmail, double branchManagerSalary) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.numEmployees = numEmployees;
        this.active = active;
        this.branchManagerName = branchManagerName;
        this.branchManagerEmail = branchManagerEmail;
        this.branchManagerSalary = branchManagerSalary;
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

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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

    public double getBranchManagerSalary() {
        return branchManagerSalary;
    }

    public void setBranchManagerSalary(double branchManagerSalary) {
        this.branchManagerSalary = branchManagerSalary;
    }

}


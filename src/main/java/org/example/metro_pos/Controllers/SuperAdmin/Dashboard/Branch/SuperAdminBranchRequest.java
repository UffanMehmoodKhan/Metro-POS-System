package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

public class SuperAdminBranchRequest {

    private String branchName;
    private String branchCity;
    private String branchAddress;
    private String branchPhone;
    private boolean branchActive;
    private int numEmployees;

    public SuperAdminBranchRequest(){

    }


    public SuperAdminBranchRequest(String branchCity, String branchAddress, String branchPhone, boolean branchActive) {
        this.branchCity = branchCity;
        this.branchAddress = branchAddress;
        this.branchPhone = branchPhone;
        this.branchActive = branchActive;
    }

    public SuperAdminBranchRequest(String branchCode, String branchName, String city, String address, String phone, boolean active, String branchCity, String branchAddress, String branchPhone, boolean branchActive, int numEmployees) {
        this.branchCity = branchCity;
        this.branchAddress = branchAddress;
        this.branchPhone = branchPhone;
        this.branchActive = branchActive;
        this.branchName = branchName;
        this.numEmployees = numEmployees;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    @Override
    public String toString(){
        return "Branch Name: " + branchName + " Branch City: " + branchCity + " Branch Address: " + branchAddress + " Branch Phone: " + branchPhone + " Branch Active: " + branchActive;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }

    public boolean isBranchActive() {
        return branchActive;
    }

    public void setBranchActive(boolean branchActive) {
        this.branchActive = branchActive;
    }
}
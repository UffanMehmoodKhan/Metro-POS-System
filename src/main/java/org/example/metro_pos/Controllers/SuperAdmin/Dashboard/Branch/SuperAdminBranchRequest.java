package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

public class SuperAdminBranchRequest {

    private String branchCode;
    private String branchName;
    private String city;
    private String address;
    private String phoneNo;
    private boolean active;
    private int employeeNum;

    public SuperAdminBranchRequest(){

    }

    public SuperAdminBranchRequest(String branchCode, String branchName, String city, String address, String phoneNo, boolean active, int employeeNum) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.city = city;
        this.address = address;
        this.phoneNo = phoneNo;
        this.active = active;
        this.employeeNum = employeeNum;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }
}

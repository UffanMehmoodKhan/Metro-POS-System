package org.example.metro_pos.Session;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

@EntityScan
public class Session implements Serializable {

    private static final long serialVersionUID = 6626553478563825579L;

    private String username;
    private String password;
    private String branchID;
    private String role;

    public Session() {
    }

    public Session(String username, String password, String branchID, String role) {
        this.username = username;
        this.password = password;
        this.branchID = branchID;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }
}

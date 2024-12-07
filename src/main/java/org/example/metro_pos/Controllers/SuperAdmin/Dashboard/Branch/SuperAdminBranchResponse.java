package org.example.metro_pos.Controllers.SuperAdmin.Dashboard.Branch;

public class SuperAdminBranchResponse {

    private final boolean branchSuccess;

    public SuperAdminBranchResponse(boolean success){
        this.branchSuccess = success;
    }

    // Getter
    public boolean getLoginSuccess(){
        return this.branchSuccess;
    }

    @Override
    public String toString() {
        return "CashierLoginResponse{" +
                "loginSuccess=" + branchSuccess +
                '}';
    }


}

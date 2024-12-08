package org.example.metro_pos.Database.DataOperator;

import org.example.metro_pos.Controllers.DataOperator.Dashboard.DataOperatorBranchResponse;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

@Service
public class DataOperatorBranchService {

    METRO_DB dataOp_DB;

    public DataOperatorBranchResponse getBranchDetails(String branchCode) {
        dataOp_DB = METRO_DB.getInstance();
        return dataOp_DB.getBranchDetails(branchCode);
    }
}
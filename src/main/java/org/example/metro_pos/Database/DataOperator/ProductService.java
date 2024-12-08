package org.example.metro_pos.Database.DataOperator;

import org.example.metro_pos.Controllers.DataOperator.Dashboard.Product;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    METRO_DB dataOp_DB;

    public List<Product> getProductsByBranch(String branchID) {
        dataOp_DB = METRO_DB.getInstance();
        return dataOp_DB.getProductsByBranch(branchID);
    }

    public Product addProduct(Product product, String branchID) {
        dataOp_DB = METRO_DB.getInstance();
        return dataOp_DB.addProduct(product, branchID);
    }

    public Product updateProduct(Product product, String branchID) {
        dataOp_DB = METRO_DB.getInstance();
        return dataOp_DB.updateProduct(product, branchID);
    }

    public void deleteProduct(String barcode, String branchID) {
        dataOp_DB = METRO_DB.getInstance();
        dataOp_DB.deleteProduct(barcode, branchID);
    }
}
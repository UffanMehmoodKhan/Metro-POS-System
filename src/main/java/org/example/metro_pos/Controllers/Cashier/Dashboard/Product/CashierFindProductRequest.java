package org.example.metro_pos.Controllers.Cashier.Dashboard.Product;


import org.example.metro_pos.Database.Cashier.CashierFindProductService;

public class CashierFindProductRequest {

    private String productBarCode;

    public CashierFindProductRequest(){
    }

    public CashierFindProductRequest(String productBarCode) {
        this.productBarCode = productBarCode;
    }


    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    @Override
    public String toString(){
        return "CashierFindProductRequest{" +
                "productBarCode='" + productBarCode + '\'' +
                '}';
    }
}

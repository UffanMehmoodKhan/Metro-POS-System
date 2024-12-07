package org.example.metro_pos.Controllers.Cashier.Dashboard.Product;

public class ProductResponse {
    private String productId;
    private String name;
    private String category;
    private double salePrice;
    private int stockQuantity;

    public ProductResponse(){

    }

    public ProductResponse(String productId, String branchCode, String vendorId, String name, String category, double originalPrice, double salePrice, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.salePrice = salePrice;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString(){
        return "ProductResponse{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", salePrice=" + salePrice +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
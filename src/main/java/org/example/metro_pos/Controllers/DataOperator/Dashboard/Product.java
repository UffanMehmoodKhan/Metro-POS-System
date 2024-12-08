package org.example.metro_pos.Controllers.DataOperator.Dashboard;

public class Product {

    private String barcode;
    private String vendor_id;
    private String name;
    private String category;
    private double original_price;
    private double sales_price;
    private int stock_quantity;

    public Product() {}

    public Product(String barcode, String vendor_id, String name, String category, double original_price, double sales_price, int stock_quantity) {
        this.barcode = barcode;
        this.vendor_id = vendor_id;
        this.name = name;
        this.category = category;
        this.original_price = original_price;
        this.sales_price = sales_price;
        this.stock_quantity = stock_quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
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

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getSales_price() {
        return sales_price;
    }

    public void setSales_price(double sales_price) {
        this.sales_price = sales_price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    // Getters and setters
}
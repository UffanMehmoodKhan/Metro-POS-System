package org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction;

import java.util.List;

public class CashierTransactionRequest {
    private List<ProductTransaction> transactionDetails;

    public List<ProductTransaction> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<ProductTransaction> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public static class ProductTransaction {
        private String productCode;
        private String productName;
        private String category;
        private double price;
        private int quantity;

        public ProductTransaction(){

        }

        public ProductTransaction(String productCode, String productName, String category, double price, int quantity) {
            this.productCode = productCode;
            this.productName = productName;
            this.category = category;
            this.price = price;
            this.quantity = quantity;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString(){
            return "ProductTransaction{" +
                    "productCode='" + productCode + '\'' +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}
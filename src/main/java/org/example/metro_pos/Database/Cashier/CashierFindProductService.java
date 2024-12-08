package org.example.metro_pos.Database.Cashier;

import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Controllers.Cashier.Dashboard.Product.ProductResponse;
import org.example.metro_pos.Database.METRO_DB;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerMapping;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class CashierFindProductService {

    METRO_DB cashier_DB;

    public CashierFindProductService(@Qualifier("resourceHandlerMapping") HandlerMapping resourceHandlerMapping) {
    }

    public ProductResponse findProduct(String productBarCode, HttpSession session) throws SQLException {
        cashier_DB = METRO_DB.getInstance();
        ResultSet productInfo = (ResultSet) cashier_DB.findProduct(productBarCode, session);

        if (productInfo.next()) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductId(productInfo.getString("product_barcode"));
            productResponse.setName(productInfo.getString("name"));
            productResponse.setCategory(productInfo.getString("category"));
            productResponse.setSalePrice(productInfo.getDouble("sale_price"));
            productResponse.setStockQuantity(productInfo.getInt("stock_quantity"));
            return productResponse;
        } else {
            return null;
        }
    }
}

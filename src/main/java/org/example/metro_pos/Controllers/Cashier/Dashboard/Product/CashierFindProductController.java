package org.example.metro_pos.Controllers.Cashier.Dashboard.Product;

import jakarta.servlet.http.HttpSession;
import org.example.metro_pos.Database.Cashier.CashierFindProductService;
import org.example.metro_pos.Session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/cashier")
public class CashierFindProductController {

    @Autowired
    private CashierFindProductService findProductService;

    @PostMapping("/find")
    public ProductResponse findProduct(@RequestBody CashierFindProductRequest request, HttpSession session) throws SQLException {
        return findProductService.findProduct(request.getProductBarCode(), session);
    }


}
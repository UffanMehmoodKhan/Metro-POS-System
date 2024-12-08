package org.example.metro_pos.Controllers;

import org.example.metro_pos.Controllers.DataOperator.Dashboard.Product;
import org.example.metro_pos.Database.DataOperator.ProductService;
import org.example.metro_pos.Session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/dataOperator/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            List<Product> products = productService.getProductsByBranch(userSession.getBranchID());
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product, HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            Product addedProduct = productService.addProduct(product, userSession.getBranchID());
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            Product updatedProduct = productService.updateProduct(product, userSession.getBranchID());
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{barcode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String barcode, HttpSession session) {
        Session userSession = (Session) session.getAttribute("userSession");
        if (userSession != null) {
            productService.deleteProduct(barcode, userSession.getBranchID());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
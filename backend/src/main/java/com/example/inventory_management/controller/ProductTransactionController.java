package com.example.inventory_management.controller;

import com.example.inventory_management.entity.Product;
import com.example.inventory_management.entity.TransactionDetails;
import com.example.inventory_management.entity.TransactionTable;
import com.example.inventory_management.service.ProductService;
import com.example.inventory_management.service.TransactionDetailsService;
import com.example.inventory_management.service.TransactionTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-transaction")
public class ProductTransactionController {
    private final ProductService productService;
    private final TransactionTableService transactionTableService;
    private final TransactionDetailsService transactionDetailsService;

    public ProductTransactionController(ProductService productService, TransactionTableService transactionTableService, TransactionDetailsService transactionDetailsService) {
        this.productService = productService;
        this.transactionTableService = transactionTableService;
        this.transactionDetailsService = transactionDetailsService;
    }

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all transactions
    @GetMapping("/transactions")
    public List<TransactionTable> getAllTransactions() {
        return transactionTableService.getAllTransactions();
    }

    // Get transaction by ID
    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionTable> getTransactionById(@PathVariable Integer id) {
        Optional<TransactionTable> transaction = transactionTableService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all transaction details
    @GetMapping("/transaction-details")
    public List<TransactionDetails> getAllTransactionDetails() {
        return transactionDetailsService.getAllTransactionDetails();
    }
}

package com.example.inventory_management.controller;

import com.example.inventory_management.entity.TransactionDetails;
import com.example.inventory_management.service.TransactionDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction-details")
public class TransactionDetailsController {
    private final TransactionDetailsService transactionDetailsService;

    public TransactionDetailsController(TransactionDetailsService transactionDetailsService) {
        this.transactionDetailsService = transactionDetailsService;
    }

    @GetMapping
    public List<TransactionDetails> getAllTransactionDetails() {
        return transactionDetailsService.getAllTransactionDetails();
    }

    @GetMapping("/{transactionId}/{productId}")
    public ResponseEntity<TransactionDetails> getTransactionDetailsById(@PathVariable Integer transactionId, @PathVariable Integer productId) {
        Optional<TransactionDetails> details = transactionDetailsService.getTransactionDetailsById(transactionId, productId);
        return details.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TransactionDetails addTransactionDetails(@RequestBody TransactionDetails transactionDetails) {
        return transactionDetailsService.saveTransactionDetails(transactionDetails);
    }

    @DeleteMapping("/{transactionId}/{productId}")
    public ResponseEntity<Void> deleteTransactionDetails(@PathVariable Integer transactionId, @PathVariable Integer productId) {
        transactionDetailsService.deleteTransactionDetails(transactionId, productId);
        return ResponseEntity.noContent().build();
    }
}

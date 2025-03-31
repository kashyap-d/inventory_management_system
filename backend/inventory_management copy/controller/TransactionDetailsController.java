package com.example.inventory_management.controller;

import com.example.inventory_management.entity.TransactionDetails;
import com.example.inventory_management.service.TransactionDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction-details")
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
        return details.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TransactionDetails createTransactionDetails(@RequestBody TransactionDetails transactionDetails) {
        return transactionDetailsService.saveTransactionDetails(transactionDetails);
    }

    @PutMapping("/{transactionId}/{productId}")
    public ResponseEntity<TransactionDetails> updateTransactionDetails(@PathVariable Integer transactionId, @PathVariable Integer productId, 
                                                                       @RequestBody TransactionDetails updatedDetails) {
        Optional<TransactionDetails> existingDetails = transactionDetailsService.getTransactionDetailsById(transactionId, productId);
        if (existingDetails.isPresent()) {
            TransactionDetails details = existingDetails.get();
            details.setQuantity(updatedDetails.getQuantity());
            details.setUnitPrice(updatedDetails.getUnitPrice());
            return ResponseEntity.ok(transactionDetailsService.saveTransactionDetails(details));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{transactionId}/{productId}")
    public ResponseEntity<Void> deleteTransactionDetails(@PathVariable Integer transactionId, @PathVariable Integer productId) {
        if (transactionDetailsService.getTransactionDetailsById(transactionId, productId).isPresent()) {
            transactionDetailsService.deleteTransactionDetails(transactionId, productId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

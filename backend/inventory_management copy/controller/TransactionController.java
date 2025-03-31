package com.example.inventory_management.controller;

import com.example.inventory_management.entity.Transaction;
import com.example.inventory_management.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}

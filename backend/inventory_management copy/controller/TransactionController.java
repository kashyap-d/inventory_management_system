package com.example.inventory_management.controller;

import com.example.inventory_management.entity.Transaction;
import com.example.inventory_management.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
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
        return transaction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction updatedTransaction) {
        Optional<Transaction> existingTransaction = transactionService.getTransactionById(id);
        if (existingTransaction.isPresent()) {
            Transaction transaction = existingTransaction.get();
            transaction.setOutlet(updatedTransaction.getOutlet());
            transaction.setCustomer(updatedTransaction.getCustomer());
            transaction.setTransactionDate(updatedTransaction.getTransactionDate());
            transaction.setTotalAmount(updatedTransaction.getTotalAmount());
            return ResponseEntity.ok(transactionService.saveTransaction(transaction));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        if (transactionService.getTransactionById(id).isPresent()) {
            transactionService.deleteTransaction(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

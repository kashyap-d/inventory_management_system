package com.example.inventory_management.service;

import com.example.inventory_management.entity.Transaction;
import com.example.inventory_management.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> getTransactionsByOutletId(Integer outletId) {
        return transactionRepository.findByOutlet_OutletID(outletId);
    }

    public List<Transaction> getTransactionsByCustomerId(Integer customerId) {
        return transactionRepository.findByCustomer_CustomerID(customerId);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}

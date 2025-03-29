package com.example.inventory_management.service;

import com.example.inventory_management.entity.TransactionTable;
import com.example.inventory_management.repository.TransactionTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTableService {
    private final TransactionTableRepository transactionTableRepository;

    public TransactionTableService(TransactionTableRepository transactionTableRepository) {
        this.transactionTableRepository = transactionTableRepository;
    }

    public List<TransactionTable> getAllTransactions() {
        return transactionTableRepository.findAll();
    }

    public Optional<TransactionTable> getTransactionById(Integer id) {
        return transactionTableRepository.findById(id);
    }

    public TransactionTable saveTransaction(TransactionTable transactionTable) {
        return transactionTableRepository.save(transactionTable);
    }

    public void deleteTransaction(Integer id) {
        transactionTableRepository.deleteById(id);
    }
}

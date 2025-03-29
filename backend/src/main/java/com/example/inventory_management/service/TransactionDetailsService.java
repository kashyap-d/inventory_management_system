package com.example.inventory_management.service;

import com.example.inventory_management.entity.TransactionDetails;
import com.example.inventory_management.entity.TransactionDetailsId;
import com.example.inventory_management.repository.TransactionDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDetailsService {
    private final TransactionDetailsRepository transactionDetailsRepository;

    public TransactionDetailsService(TransactionDetailsRepository transactionDetailsRepository) {
        this.transactionDetailsRepository = transactionDetailsRepository;
    }

    public List<TransactionDetails> getAllTransactionDetails() {
        return transactionDetailsRepository.findAll();
    }

    public Optional<TransactionDetails> getTransactionDetailsById(TransactionDetailsId id) {
        return transactionDetailsRepository.findById(id);
    }

    public TransactionDetails saveTransactionDetails(TransactionDetails transactionDetails) {
        return transactionDetailsRepository.save(transactionDetails);
    }

    public void deleteTransactionDetails(TransactionDetailsId id) {
        transactionDetailsRepository.deleteById(id);
    }
}

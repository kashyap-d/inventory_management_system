package com.example.inventory_management.service;

import com.example.inventory_management.entity.TransactionDetails;
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

    public Optional<TransactionDetails> getTransactionDetailsById(Integer transactionId, Integer productId) {
        return transactionDetailsRepository.findByTransaction_TransactionIDAndProduct_ProductID(transactionId, productId);
    }

    public TransactionDetails saveTransactionDetails(TransactionDetails transactionDetails) {
        return transactionDetailsRepository.save(transactionDetails);
    }

    public void deleteTransactionDetails(Integer transactionId, Integer productId) {
        transactionDetailsRepository.deleteByTransaction_TransactionIDAndProduct_ProductID(transactionId, productId);
    }
}

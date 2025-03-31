package com.example.inventory_management.service;

import com.example.inventory_management.entity.DeliveryDetails;
import com.example.inventory_management.repository.DeliveryDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDetailsService {
    private final DeliveryDetailsRepository deliveryDetailsRepository;

    public DeliveryDetailsService(DeliveryDetailsRepository deliveryDetailsRepository) {
        this.deliveryDetailsRepository = deliveryDetailsRepository;
    }

    public List<DeliveryDetails> getAllDeliveryDetails() {
        return deliveryDetailsRepository.findAll();
    }

    public Optional<DeliveryDetails> getDeliveryDetailsById(Integer deliveryId, Integer productId) {
        return deliveryDetailsRepository.findByDelivery_DeliveryIDAndProduct_ProductID(deliveryId, productId);
    }

    public DeliveryDetails saveDeliveryDetails(DeliveryDetails deliveryDetails) {
        return deliveryDetailsRepository.save(deliveryDetails);
    }

    public void deleteDeliveryDetails(Integer deliveryId, Integer productId) {
        deliveryDetailsRepository.deleteByDelivery_DeliveryIDAndProduct_ProductID(deliveryId, productId);
    }
}

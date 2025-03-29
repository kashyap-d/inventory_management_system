package com.example.inventory_management.service;

import com.example.inventory_management.entity.DeliveryDetails;
import com.example.inventory_management.entity.DeliveryDetailsId;
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

    public Optional<DeliveryDetails> getDeliveryDetailsById(DeliveryDetailsId id) {
        return deliveryDetailsRepository.findById(id);
    }

    public DeliveryDetails saveDeliveryDetails(DeliveryDetails deliveryDetails) {
        return deliveryDetailsRepository.save(deliveryDetails);
    }

    public void deleteDeliveryDetails(DeliveryDetailsId id) {
        deliveryDetailsRepository.deleteById(id);
    }
}

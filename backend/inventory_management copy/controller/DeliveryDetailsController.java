package com.example.inventory_management.controller;

import com.example.inventory_management.entity.DeliveryDetails;
import com.example.inventory_management.service.DeliveryDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery-details")
public class DeliveryDetailsController {
    private final DeliveryDetailsService deliveryDetailsService;

    public DeliveryDetailsController(DeliveryDetailsService deliveryDetailsService) {
        this.deliveryDetailsService = deliveryDetailsService;
    }

    @GetMapping
    public List<DeliveryDetails> getAllDeliveryDetails() {
        return deliveryDetailsService.getAllDeliveryDetails();
    }

    @GetMapping("/{deliveryId}/{productId}")
    public ResponseEntity<DeliveryDetails> getDeliveryDetailsById(@PathVariable Integer deliveryId, @PathVariable Integer productId) {
        return deliveryDetailsService.getDeliveryDetailsById(deliveryId, productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DeliveryDetails createDeliveryDetails(@RequestBody DeliveryDetails deliveryDetails) {
        return deliveryDetailsService.saveDeliveryDetails(deliveryDetails);
    }

    @DeleteMapping("/{deliveryId}/{productId}")
    public ResponseEntity<Void> deleteDeliveryDetails(@PathVariable Integer deliveryId, @PathVariable Integer productId) {
        deliveryDetailsService.deleteDeliveryDetails(deliveryId, productId);
        return ResponseEntity.noContent().build();
    }
}

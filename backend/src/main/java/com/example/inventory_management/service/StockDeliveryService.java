package com.example.inventory_management.service;

import com.example.inventory_management.entity.StockDelivery;
import com.example.inventory_management.repository.StockDeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockDeliveryService {
    private final StockDeliveryRepository stockDeliveryRepository;

    public StockDeliveryService(StockDeliveryRepository stockDeliveryRepository) {
        this.stockDeliveryRepository = stockDeliveryRepository;
    }

    public List<StockDelivery> getAllStockDeliveries() {
        return stockDeliveryRepository.findAll();
    }

    public Optional<StockDelivery> getStockDeliveryById(Integer id) {
        return stockDeliveryRepository.findById(id);
    }

    public StockDelivery saveStockDelivery(StockDelivery stockDelivery) {
        return stockDeliveryRepository.save(stockDelivery);
    }

    public void deleteStockDelivery(Integer id) {
        stockDeliveryRepository.deleteById(id);
    }
}

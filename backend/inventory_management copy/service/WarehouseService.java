package com.example.inventory_management.service;

import com.example.inventory_management.entity.Warehouse;
import com.example.inventory_management.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(Integer id) {
        return warehouseRepository.findById(id);
    }

    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
    }
}

package com.example.inventory_management.repository;

import com.example.inventory_management.entity.OutletInventory;
import com.example.inventory_management.entity.Outlet;
import com.example.inventory_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OutletInventoryRepository extends JpaRepository<OutletInventory, Integer> {
    Optional<OutletInventory> findByOutlet_OutletIDAndProduct_ProductID(Integer outletId, Integer productId);
    void deleteByOutlet_OutletIDAndProduct_ProductID(Integer outletId, Integer productId);
}

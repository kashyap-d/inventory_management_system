package com.example.inventory_management.repository;

import com.example.inventory_management.entity.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Integer> {
}

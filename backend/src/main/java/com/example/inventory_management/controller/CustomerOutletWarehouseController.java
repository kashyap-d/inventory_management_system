package com.example.inventory_management.controller;

import com.example.inventory_management.entity.Customer;
import com.example.inventory_management.entity.Outlet;
import com.example.inventory_management.entity.StockDelivery;
import com.example.inventory_management.entity.Warehouse;
import com.example.inventory_management.service.CustomerService;
import com.example.inventory_management.service.OutletService;
import com.example.inventory_management.service.StockDeliveryService;
import com.example.inventory_management.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer-outlet-warehouse")
public class CustomerOutletWarehouseController {
    private final CustomerService customerService;
    private final OutletService outletService;
    private final WarehouseService warehouseService;
    private final StockDeliveryService stockDeliveryService;

    public CustomerOutletWarehouseController(CustomerService customerService, OutletService outletService, WarehouseService warehouseService, StockDeliveryService stockDeliveryService) {
        this.customerService = customerService;
        this.outletService = outletService;
        this.warehouseService = warehouseService;
        this.stockDeliveryService = stockDeliveryService;
    }

    // Get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all outlets
    @GetMapping("/outlets")
    public List<Outlet> getAllOutlets() {
        return outletService.getAllOutlets();
    }

    // Get all warehouses
    @GetMapping("/warehouses")
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    // Get all stock deliveries
    @GetMapping("/stock-deliveries")
    public List<StockDelivery> getAllStockDeliveries() {
        return stockDeliveryService.getAllStockDeliveries();
    }
}

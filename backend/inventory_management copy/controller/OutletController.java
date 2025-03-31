package com.example.inventory_management.controller;

import com.example.inventory_management.entity.Outlet;
import com.example.inventory_management.service.OutletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/outlets")
public class OutletController {
    private final OutletService outletService;

    public OutletController(OutletService outletService) {
        this.outletService = outletService;
    }

    @GetMapping
    public List<Outlet> getAllOutlets() {
        return outletService.getAllOutlets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outlet> getOutletById(@PathVariable Integer id) {
        return outletService.getOutletById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Outlet createOutlet(@RequestBody Outlet outlet) {
        return outletService.saveOutlet(outlet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutlet(@PathVariable Integer id) {
        outletService.deleteOutlet(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.inventory_management.service;

import com.example.inventory_management.entity.Outlet;
import com.example.inventory_management.repository.OutletRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OutletService {
    private final OutletRepository outletRepository;

    public OutletService(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    public List<Outlet> getAllOutlets() {
        return outletRepository.findAll();
    }

    public Optional<Outlet> getOutletById(Integer id) {
        return outletRepository.findById(id);
    }

    public Outlet saveOutlet(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    public void deleteOutlet(Integer id) {
        outletRepository.deleteById(id);
    }
}

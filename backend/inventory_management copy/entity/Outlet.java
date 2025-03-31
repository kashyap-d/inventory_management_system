package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "outlet")
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer outletId;

    @Column(nullable = false, length = 50)
    private String branchName;

    @Column(length = 100)
    private String location;

    @OneToMany(mappedBy = "outlet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutletInventory> outletInventories;
}

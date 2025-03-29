package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer outletID;

    @Column(nullable = false, length = 50)
    private String branchName;

    @Column(length = 100)
    private String location;
}

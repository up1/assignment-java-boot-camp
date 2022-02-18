package com.example.assignmentjavabootcamp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shoppingcart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingcartId;

    @OneToMany
    private List<Product> products = new ArrayList<>();
}

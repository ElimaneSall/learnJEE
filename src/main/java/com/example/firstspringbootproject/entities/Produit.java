package com.example.firstspringbootproject.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="produit")
@Getter
@Setter
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double prix;
}

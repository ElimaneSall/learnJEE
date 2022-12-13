package com.example.firstspringbootproject.repositories;

import com.example.firstspringbootproject.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepo extends JpaRepository<Produit, Long> {
    public List<Produit> findByNomContains(String key);
    List<Produit> findByNomContainsAndPrix(String key, double p);
}

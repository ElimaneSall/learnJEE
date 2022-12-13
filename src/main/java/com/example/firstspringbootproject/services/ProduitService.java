package com.example.firstspringbootproject.services;

import com.example.firstspringbootproject.entities.Produit;
import com.example.firstspringbootproject.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    ProduitRepo produitRepo ;
    public List<Produit> getProduits(){
        return produitRepo.findAll();
    }
    public Produit saveProduit(Produit p){
        return produitRepo.save(p);
    }
    public void deleteById(Long id) {
        produitRepo.deleteById(id);
    }
    public List<Produit> getContain(String key) {
        return produitRepo.findByNomContainsAndPrix(key, 123.0);
    }
    public Optional<Produit> getContainById(Long id) {
        return  produitRepo.findById(id);
    }

    public Optional<Produit> findById(Long id) {
        return  produitRepo.findById(id);
    }
}

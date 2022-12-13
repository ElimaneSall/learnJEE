package com.example.firstspringbootproject;

import com.example.firstspringbootproject.entities.Produit;
import com.example.firstspringbootproject.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FirstSpringBootProjectApplication implements CommandLineRunner {
@Autowired//injection de dependance
private ProduitService produitService;
    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("La liste de tous les appareils");
        produitService.getProduits().forEach(produit -> {
            System.out.println(produit.getNom());
        });
        System.out.println("Trouver par Id");
        try {
            produitService.findById(15L).get();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Apres");
        List<Produit> produits1 = produitService.getContain("I");
        produits1.forEach((produit -> {
            System.out.println(produit.getNom());
        }));
        System.out.println("Trouver par key and value");
        List<Produit> produits2 = produitService.getContain("I");
        produits2.forEach((produit -> {
            System.out.println(produit.getNom() +" " + produit.getPrix().toString());
        }));

    }
}

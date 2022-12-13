package com.example.firstspringbootproject.web;

import com.example.firstspringbootproject.entities.Produit;
import com.example.firstspringbootproject.services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping(path = "produits")
public class ProduitController {
    @Autowired//injection de dependance
     ProduitService produitService ;
    @PostMapping
    public  ResponseEntity<Object> saveData( @RequestBody Produit p){
        produitService.saveProduit(p);
        return new ResponseEntity <>(p, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Object> getAllProduct(){
        return new ResponseEntity <>(produitService.getProduits(), HttpStatus.OK);
    }
    @GetMapping("/pageProduit")
    public String pagePro(Model model ){
        model.addAttribute("listproduits",produitService.getProduits() );
        return "prod";
    }
    //Save
    @GetMapping("/showForm")
    public String ShowForm(Model model){
        model.addAttribute("produit", new Produit());
        return "addProd";
    }

    //delete
    @GetMapping("/delete")
    public String delete(Long id){
        produitService.deleteById(id);
        return "redirect:/";
    }
    //update
    @GetMapping("/ShowFormUpdate")
    public String ShowFormUpdate(Long id, Model model){
        try {
            model.addAttribute("produit",produitService.getContainById(id));
            System.out.println(model.getAttribute("produit"));
        }catch (Exception e){
            System.out.println(e);
        }
        return "updateForm";
    }
    @PostMapping("/saveUpdateData")
    public String update(Produit p){
        produitService.saveProduit(p);
        return "redirect:/";
    }
    @GetMapping("/produits/{id}")
    public Produit produit(@PathVariable Long id ){
        return (Produit) produitService.getContain(String.valueOf(id));
    }
}

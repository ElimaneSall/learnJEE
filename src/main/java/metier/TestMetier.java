package metier;

import java.util.List;

public class TestMetier {
    public static void main(String[] args) {
        ImpleMetierProduit metier = new ImpleMetierProduit();
        List<Produit> prods = metier.getProduitsParMC("I");
        List<Produit> produitAll = metier.getAllProduits();
        System.out.println("-".repeat(30));
        System.out.println("Tous les produits");
        for (Produit p:produitAll){
            System.out.println("numero " + p.getIdPorduit());
            System.out.println(p.getNomProduit());
        }
        System.out.println("-".repeat(30));
        System.out.println("Produit ayant I");
        for (Produit p:prods){
            System.out.println(p.getNomProduit());
        }
    }
}

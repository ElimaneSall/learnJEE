package modele;

import metier.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitModel {
    private String motCle;
    private List<Produit> prods = new ArrayList();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Produit> getProds() {
        return prods;
    }

    public void setProds(List<Produit> prods) {
        this.prods = prods;
    }
}

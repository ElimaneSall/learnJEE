package metier;

import java.util.List;

public interface IMetierProduit {
    public List<Produit> getProduitsParMC(String mc);
    public List<Produit> getAllProduits();
    public void addProduit(Produit p);
}

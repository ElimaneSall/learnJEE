package metier;

import java.io.Serializable;

public class Produit implements Serializable {
    private  Long idPorduit;
    private String nomProduit;
    private double prixProduit;

    public Long getIdPorduit() {
        return idPorduit;
    }

    public void setIdPorduit(Long idPorduit) {
        this.idPorduit = idPorduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }
}

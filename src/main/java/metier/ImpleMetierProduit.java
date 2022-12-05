package metier;

import repositories.ConnexionBDEcommece;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpleMetierProduit implements IMetierProduit{
    @Override
    public List<Produit> getProduitsParMC(String mc) {
       List<Produit> prods = new ArrayList<>();
        Connection conn = ConnexionBDEcommece.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from Produit where  nom like ?");
            ps.setString(1, "%"+mc+"%");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Produit p = new Produit();
                p.setIdPorduit(rs.getLong("idProduit"));
                p.setNomProduit(rs.getString("nom"));
                p.setPrixProduit(rs.getDouble("prix"));
                prods.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prods;
    }

    @Override
    public List<Produit> getAllProduits() {
        List<Produit> prods = new ArrayList<>();
        Connection con = ConnexionBDEcommece.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("select * from produit");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Produit p = new Produit();
                p.setIdPorduit(rs.getLong("idProduit"));
                p.setNomProduit(rs.getString("nom"));
                p.setPrixProduit(rs.getDouble("prix"));
                prods.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prods;
    }

    @Override
    public void addProduit(Produit p) {

    }
}

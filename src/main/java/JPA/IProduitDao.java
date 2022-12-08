package JPA;

import java.util.List;

public interface IProduitDao {
    public void save(Produit p) ;
    public List<Produit> findAll();
    public List<Produit> findByName(String mc);
    public Produit findByID(Long id);
    public void update(Produit p);
    public void deleteByID(Long id);

}

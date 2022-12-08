package JPA;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "Produit")
public class Produit implements Serializable {
   @Id
    private Long id;
   private String nom;
   private Double prix;
}

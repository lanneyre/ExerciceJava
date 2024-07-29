package csm.boutique;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Accessoire extends Produit {
    private final String description;

    @JsonCreator
    public Accessoire(  @JsonProperty("nom") String nom, 
                        @JsonProperty("prix") double prix, 
                        @JsonProperty("quantite") int quantite, 
                        @JsonProperty("description") String description) {
        super(nom, prix, quantite);
        this.description = description;
    }
    

    public String getDescription() {
        return description;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom : " + getNom() + ", Prix : " + getPrix() + ", Quantité : " + getQuantite() + ", Description : " + description);
    }

}

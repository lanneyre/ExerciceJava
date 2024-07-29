package csm.boutique;

import java.util.LinkedHashMap;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class The extends Produit {
    private final String type; // Vert, Noir, Oolong, etc.

    @JsonCreator
    public The( @JsonProperty("nom") String nom, 
                @JsonProperty("prix") double prix, 
                @JsonProperty("quantite") int quantite, 
                @JsonProperty("type") String type) {
        super(nom, prix, quantite);
        this.type = type;
    }


    public String getType() {
        return type;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom : " + getNom() + ", Prix : " + getPrix() + ", Quantité : " + getQuantite() + ", Type : " + type);
    }

    // @Override 
    // public LinkedHashMap getdetailsArray(){
    //     LinkedHashMap  m = new LinkedHashMap(4);
    //     m.put("nom", this.getNom());
    //     m.put("prix", this.getPrix());
    //     m.put("quantite", this.getQuantite());
    //     m.put("type", this.getType());

    //     return m;

    // }
}

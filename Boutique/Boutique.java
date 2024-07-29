import java.util.ArrayList;
import org.json.simple.*;

public class Boutique {
    private final ArrayList<Produit> produits;

    public Boutique() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void afficherProduits() {
        for (Produit produit : produits) {
            produit.afficherDetails();
        }
    }

    public void saveListe(){
        String jsonStr = JSONArray.toJSONString(list);
        try { 
            String jsonArray 
                = objectMapper.writeValueAsString(courses); 
            System.out.println(jsonArray); 
        } 
        catch (JsonProcessingException e) { 
            e.printStackTrace(); 
        } 
    }

    public void passerCommande(String nomProduit, int quantite) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nomProduit)) {
                if (produit.getQuantite() >= quantite) {
                    produit.setQuantite(produit.getQuantite() - quantite);
                    System.out.println("Commande passée pour " + quantite + " " + nomProduit + "(s).");
                } else {
                    System.out.println("Quantité insuffisante pour " + nomProduit + ".");
                }
                return;
            }
        }
        System.out.println("Produit " + nomProduit + " non trouvé.");
    }
}

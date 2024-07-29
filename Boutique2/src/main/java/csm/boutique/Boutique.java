package csm.boutique;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper; 

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
    public void getProduits(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream input = new FileInputStream("Produits.json");
            List<Produit> listeProduitsFromJSON = objectMapper.readValue(input, new TypeReference<List<Produit>>() {});
            for (Produit p : listeProduitsFromJSON) {
                produits.add(p);
            }
        } catch(FileNotFoundException e){
            System.out.println("erreur");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    
    public void saveListe(){
         
        ObjectMapper mapper = new ObjectMapper();
        try {
            //je créé une ressource vers le fichier json
            PrintWriter pw = new PrintWriter("Produits.json");
            TypeReference typeToSave = new TypeReference<List<Produit>>() {};
            mapper.writerFor(typeToSave).writeValue(pw, produits);
        } catch (Exception  e) {
            System.out.println("erreur : " +e.getMessage());
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

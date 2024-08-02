package csm.boutique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Boutique {
    private ArrayList<Produit> produits = new ArrayList<Produit>();


    public Boutique() {
        this.getProduits();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void afficherProduits() {
        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }
    public void getProduits(){
       try {
            // use con here
            produits.clear();
            Connection con = Bdd.getCon();
            System.out.println("connexion réussie");
            Statement stmt = con.createStatement();
            String selectSql = "SELECT * FROM produits"; 
            ResultSet resultSet = stmt.executeQuery(selectSql);

            while (resultSet.next()) {
                produits.add(new Produit(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getDouble("prix"), resultSet.getInt("quantite"), resultSet.getString("description"), Categorie.categorieById(resultSet.getInt("categorie_id"))));
            }

        } catch(SQLException e) {
            System.out.println("Connexion échouée");
        }
        
    }
    
    public void saveListe(){
        for (Produit produit : produits) {
            produit.save();
        }
        this.getProduits();
    }

    public void passerCommande(int produitid, int quantite) {
        for (Produit produit : produits) {
            if (produit.getId() == produitid) {
                if (produit.getQuantite() >= quantite) {
                    produit.setQuantite(produit.getQuantite() - quantite);
                    System.out.println("Commande passée pour " + quantite + " " + produit.getNom() + "(s).");
                } else {
                    System.out.println("Quantité insuffisante pour " + produit.getNom() + ".");
                }
                return;
            }
        }
        System.out.println("Produit " + produitid + " non trouvé.");
    }
}

package csm.boutique;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produit{
    private int id = 0; 
    private String nom;
    private double prix;
    private int quantite;
    private String description;

    private PreparedStatement pstmtSave;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    private Categorie categorie;

    public Produit(int id, String nom, double prix, int quantite, String description, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.description = description;
        this.categorie = categorie;        
    }
    public Produit(String nom, double prix, int quantite, String description, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.description = description;
        this.categorie = categorie;        
    }

    public static Produit produitById(int IdProd){
        try {
            PreparedStatement pstmt = bdd.getPreparedStmt("getProduitById");

            pstmt.setInt(1, IdProd);
            ResultSet resultSet = pstmt.executeQuery();

            return new Produit(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getDouble("prix"), resultSet.getInt("quantite"), resultSet.getString("description"), Categorie.categorieById(resultSet.getInt("categorie_id")));
        
        } catch(SQLException e) {
            System.out.println("Connexion échouée");
        }
        return null;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Id : " + getId() +"\nNom : " + getNom() + ", \nPrix : " + getPrix() + ", \nQuantité : " + getQuantite() + ", \nDescription : " + description + ", \nCatégorie : "+getCategorie()+"\n";
    }

    public void save(){
        try {
            if (this.id == 0) {
                pstmtSave = bdd.getPreparedStmt("createProduit");
            } else {
                pstmtSave = bdd.getPreparedStmt("updateProduit");
                pstmtSave.setInt(6, this.id);
            }
            pstmtSave.setString(1, this.nom);
            pstmtSave.setDouble(2, this.prix);
            pstmtSave.setInt(3, this.quantite);
            pstmtSave.setString(4, this.description);
            pstmtSave.setInt(5, this.categorie.getId());
            
            pstmtSave.execute();
           
        
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Impossible de sauvegardé le Produit");
        }
    }
}

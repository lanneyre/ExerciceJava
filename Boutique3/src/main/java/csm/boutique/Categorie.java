package csm.boutique;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Categorie {
    private int id;
    private String nom;
    private int parent;

    private PreparedStatement pstmtSave;

    public Categorie(int Id, String nom, int parent) {
        this.id = Id;
        this.nom = nom;
        this.parent = parent;
    }

    public int getParent() {
        return this.parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static Categorie categorieById(int IdCat){
        try  {
                        
            PreparedStatement pstmt = bdd.getPreparedStmt("getCategorieById");
            pstmt.setInt(1, IdCat);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            return new Categorie(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getInt("parent"));
        
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", parent='" + getParent() + "'" +
            "}";
    }

    public void save(){
        try {
            if (this.id == 0) {
                pstmtSave = bdd.getPreparedStmt("createCategorie");
            } else {
                pstmtSave = bdd.getPreparedStmt("updateCategorie");
                pstmtSave.setInt(3, this.id);
            }
            pstmtSave.setString(1, this.nom);
            pstmtSave.setDouble(2, this.parent);
           
            
            pstmtSave.execute();
           
        
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Impossible de sauvegardé le Produit");
        }
    }
}

    

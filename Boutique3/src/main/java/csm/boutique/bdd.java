package csm.boutique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class bdd {
    public static Connection con = null;

    public static Connection getCon () throws SQLException{
        if(bdd.con == null){
            bdd.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theboutique", "theboutique", "3QicZi82K@dkTm9H");
        }
        return bdd.con;
    }

    public static PreparedStatement getPreparedStmt(String requete){
        HashMap<String, String> preparedstmt = new HashMap<String, String>();
        preparedstmt.put("updateProduit", "UPDATE `produits` SET `nom` = ?, `prix` = ?, `quantite` = ?,`description` = ?,`categorie_id` = ? WHERE `produits`.`Id` = ?;");    
        preparedstmt.put("createProduit", "INSERT INTO `produits` (`nom`, `prix`, `quantite`, `description`, `categorie_id`) VALUES (?, ?, ?, ?, ?);");    
        preparedstmt.put("getProduitById", "SELECT * FROM produits WHERE Id = ? LIMIT 1"); 
        
        preparedstmt.put("updateCategorie", "UPDATE `categories` SET `nom` = ?, `parent` = ? WHERE `categories`.`Id` = ?;");    
        preparedstmt.put("createCategorie", "INSERT INTO `categories` (`nom`, `parent`) VALUES (?, ?);");    
        preparedstmt.put("getCategorieById", "SELECT * FROM `categories` WHERE `Id`=? LIMIT 1"); 
         
        try {
            Connection con = bdd.getCon();
            return con.prepareStatement(preparedstmt.get(requete));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

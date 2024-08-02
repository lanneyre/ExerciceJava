package csm.boutique;

/**
 *
 * @author lanney
 */
public class Main {
    public static void main(String[] args) {
        Boutique boutique = new Boutique();

        //Produit theBlanc = new Produit("The Blanc", 10.0, 50, "Thé Vert mais blanc", Categorie.categorieById(4));
        //boutique.ajouterProduit(theBlanc);
       
        
        boutique.afficherProduits();

        boutique.passerCommande(1, 10);
        boutique.passerCommande(2, 20);

        boutique.saveListe();
        boutique.afficherProduits();
    }
}

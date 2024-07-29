package csm.boutique;

/**
 *
 * @author lanney
 */
public class Main {
    public static void main(String[] args) {
        Boutique boutique = new Boutique();

        // The theVert = new The("The Vert", 10.0, 50, "Vert");
        // The theNoir = new The("The Noir", 12.0, 30, "Noir");
        // Accessoire tasse = new Accessoire("Tasse en ceramique", 8.0, 100, "Tasse en ceramique elegante");

        // boutique.ajouterProduit(theVert);
        // boutique.ajouterProduit(theNoir);
        // boutique.ajouterProduit(tasse);
        // boutique.getProduits();

        // boutique.saveListe();
        boutique.getProduits();
        boutique.afficherProduits();

        boutique.passerCommande("The Vert", 10);
        boutique.passerCommande("Tasse en ceramique", 2);
        boutique.passerCommande("The Blanc", 5); // Produit non existant

        boutique.saveListe();
        boutique.afficherProduits();
    }
}

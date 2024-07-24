public class Main {
    public static void main(String[] args) {
        Boutique boutique = new Boutique();

        The theVert = new The("Thé Vert", 10.0, 50, "Vert");
        The theNoir = new The("Thé Noir", 12.0, 30, "Noir");
        Accessoire tasse = new Accessoire("Tasse en céramique", 8.0, 100, "Tasse en céramique élégante");

        boutique.ajouterProduit(theVert);
        boutique.ajouterProduit(theNoir);
        boutique.ajouterProduit(tasse);

        boutique.afficherProduits();

        boutique.passerCommande("Thé Vert", 10);
        boutique.passerCommande("Tasse en céramique", 2);
        boutique.passerCommande("Thé Blanc", 5); // Produit non existant

        boutique.afficherProduits();
    }
}

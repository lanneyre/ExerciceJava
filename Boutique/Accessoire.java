public class Accessoire extends Produit {
    private final String description;

    public Accessoire(String nom, double prix, int quantite, String description) {
        super(nom, prix, quantite);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom : " + getNom() + ", Prix : " + getPrix() + ", Quantité : " + getQuantite() + ", Description : " + description);
    }
}

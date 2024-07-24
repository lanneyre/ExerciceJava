public class The extends Produit {
    private String type; // Vert, Noir, Oolong, etc.

    public The(String nom, double prix, int quantite, String type) {
        super(nom, prix, quantite);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Nom : " + getNom() + ", Prix : " + getPrix() + ", Quantité : " + getQuantite() + ", Type : " + type);
    }
}

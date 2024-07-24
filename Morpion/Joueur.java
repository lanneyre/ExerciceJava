public class Joueur {
    private String nom;
    private char symbole;

    public Joueur(String nom, char symbole) {
        this.nom = nom;
        this.symbole = symbole;
    }

    public String getNom() {
        return nom;
    }

    public char getSymbole() {
        return symbole;
    }
}

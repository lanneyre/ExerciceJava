import java.util.Scanner;

public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurCourant;

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.plateau = new Plateau();
        this.joueurCourant = joueur1;
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            plateau.afficherGrille();
            System.out.println("C'est le tour de " + joueurCourant.getNom() + " (" + joueurCourant.getSymbole() + ")");
            int ligne, colonne;
            do {
                System.out.print("Entrez la ligne (0, 1, 2) : ");
                ligne = scanner.nextInt();
                System.out.print("Entrez la colonne (0, 1, 2) : ");
                colonne = scanner.nextInt();
            } while (!plateau.placerSymbole(ligne, colonne, joueurCourant.getSymbole()));

            if (plateau.estGagnant(joueurCourant.getSymbole())) {
                plateau.afficherGrille();
                System.out.println("Félicitations " + joueurCourant.getNom() + "! Vous avez gagné.");
                break;
            }

            if (plateau.estPlein()) {
                plateau.afficherGrille();
                System.out.println("Match nul !");
                break;
            }

            joueurCourant = (joueurCourant == joueur1) ? joueur2 : joueur1;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Joueur joueur1 = new Joueur("Joueur 1", 'X');
        Joueur joueur2 = new Joueur("Joueur 2", 'O');
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.jouer();
    }
}
public class Plateau {
    private char[][] grille;
    private int taille = 3;

    public Plateau() {
        grille = new char[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = '-';
            }
        }
    }

    public boolean estPlein() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean estGagnant(char symbole) {
        for (int i = 0; i < taille; i++) {
            if (grille[i][0] == symbole && grille[i][1] == symbole && grille[i][2] == symbole) {
                return true;
            }
            if (grille[0][i] == symbole && grille[1][i] == symbole && grille[2][i] == symbole) {
                return true;
            }
        }
        if (grille[0][0] == symbole && grille[1][1] == symbole && grille[2][2] == symbole) {
            return true;
        }
        if (grille[0][2] == symbole && grille[1][1] == symbole && grille[2][0] == symbole) {
            return true;
        }
        return false;
    }

    public boolean placerSymbole(int ligne, int colonne, char symbole) {
        if (grille[ligne][colonne] == '-') {
            grille[ligne][colonne] = symbole;
            return true;
        }
        return false;
    }

    public void afficherGrille() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }
}

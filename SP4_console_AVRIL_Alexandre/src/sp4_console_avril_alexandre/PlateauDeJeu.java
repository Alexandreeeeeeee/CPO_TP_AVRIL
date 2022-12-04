package sp4_console_avril_alexandre;

public class PlateauDeJeu {
    CelluleDeGrille[][] Grille = new CelluleDeGrille[6][7];

// création du plateau  de jeu sous forme de grille.  
    
    public PlateauDeJeu() {
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                Grille[l][c] = new CelluleDeGrille();
            }
        }
    }
    
// ajout d'un jeton.   
         
public boolean ajouterJetonDansColonne(Jeton j, int c ){
        for (int i = 0; i<6; i++) {
            if (Grille[i][c].affecterJeton(j) == true) {
               return true;
            }
        }
        return false;
}

// 2 méthodes qui gèrent le statut de la grille de jeux.

    public boolean grilleRemplie(){ 
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                if (Grille[l][c] != null) { 
                    return false; 
                }
            }
        }
        return true;
    }
   
    public void viderGrille (Joueur j1, Joueur j2){  
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                Jeton jp = Grille[l][c].recupererJeton();
                if (jp != null) {
                    if ("rouge".equals(jp.lireCouleur())) {
                        j1.ajouterJeton(jp);
                    }
                    else {
                        j2.ajouterJeton(jp);
                    }
                }
            }
        }
    }
     
public static final String TEST = "\u001B[30m"; // création d'un fond noir qui sera utilisé ou non.
    
  public void afficherGrilleSurConsole(){
        System.out.print("\n" + "|");
        for (int l = 5; l>=0; l--) {
            for (int c = 0; c< 7; c++) {
                if ("Rouge".equals(Grille[l][c].lireCouleurDuJeton())) {
                    System.out.print("|R|");
                } 
                else if ("Jaune".equals(Grille[l][c].lireCouleurDuJeton())) {
                    System.out.print("|J|");
                } 
                else {
                    System.out.print(" - ");
                }
            }
            if (l >= 0) {
                System.out.print("|\n|");
            } else {
                System.out.println("");
            }
        }
    }
  
    public boolean presenceJeton(int x, int y) {
        return Grille[x-1][y-1].presenceJeton();
    }
    
    public String lireCouleurDuJeton(int x, int y) {
        return Grille[x][y].lireCouleurDuJeton();
    }
    
// Ligne gagante //
    
  public boolean ligneGagnantePourCouleur(String r) {
        int cpt = 0;
        boolean rep = false;
        for (int i = 0; i<6; i++) {
            for (int j = 0; j<7; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == r) {
                    cpt += 1;
                    if (cpt == 4) {
                        rep = true;                       
                        return rep;                        
                    }
                }
                else {
                    cpt = 0;
                }
            }
        }
        return rep;
    }
    
// Colonne gagnante //
  
    public boolean colonneGagnantePourCouleur(String r) {
        int cpt = 0;
        boolean rep = false;
        for (int j = 0; j<7; j++) {
            for (int i = 0; i<6; i++) {
                if (Grille[i][j].lireCouleurDuJeton() == r) {
                    cpt += 1;
                    if (cpt == 4) {
                        rep = true;                       
                        return rep;                        
                    }
                }
                else {
                    cpt = 0;
                }
            }
        }
        return rep;

        
    }
    
// Diagonale montante gagnante //
    
    public boolean diagonaleMontanteGagnantePourCouleur(String r) {
        boolean rep = false;
        for (int i = 3; i<6; i++) {
            for (int j = 0; j<4; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == r) {
                    if (Grille[i-1][j+1].lireCouleurDuJeton() == r && Grille[i-2][j+2].lireCouleurDuJeton() == r && Grille[i-3][j+3].lireCouleurDuJeton() == r) {
                        rep = true;
                        return rep;
                    }
                }
            }
        }
        return rep;
    }
        
// Diagonale descendante gagnante //
    
    public boolean diagonaleDescendanteGagnantePourCouleur(String r) {
        boolean rep = false;
        for (int i = 3; i<6; i++) {
            for (int j = 3; j<7; j++) {
                if (Grille[i][j].lireCouleurDuJeton() == r) {
                    if (Grille[i-1][j-1].lireCouleurDuJeton() == r && Grille[i-2][j-2].lireCouleurDuJeton() == r && Grille[i-3][j-3].lireCouleurDuJeton() == r) {
                        rep = true;
                        return rep;
                    }
                }
            }
        }
        return rep;
    }
    
/*/ Cette fonction nous servira par la suite à afficher un message indiquiquant si la partie s'est soldée 
    d'une égalité ou d'une victoire, mais de qui ?
/*/
    public boolean etreGagnantePourCouleur(String r) {
        if (ligneGagnantePourCouleur(r) == true || colonneGagnantePourCouleur(r) == true || diagonaleMontanteGagnantePourCouleur(r) == true || diagonaleDescendanteGagnantePourCouleur(r) == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void tasserColonne(int unecolonne) {
        int lignes = 0;
        while (Grille[lignes][unecolonne].jetonCourant != null) {
                lignes++;
            
        }
        for (int i = lignes; i < 5; i++) {
            Grille[i][unecolonne].jetonCourant = Grille[i + 1][unecolonne].jetonCourant;
            Grille[i+1][unecolonne].jetonCourant = null;
        }
        Grille[5][unecolonne].jetonCourant = null;
    }
    
    public boolean colonneRemplie(int a) {
        boolean res = true;
        for (int i = 0; i<6; i++) {
            if (Grille[i][a-1].presenceJeton() == false) {
                res = false;
                return res;
            }
        }
        return res;
    }
    
    public boolean presenceTrouNoir(int m, int z) {
        return Grille[m-1][z-1].presenceTrouNoir() == true;
    }
    
    public boolean placerTrouNoir(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].placerTrouNoir();
    }
    
    public boolean suppprimerTrouNoir(int x, int y) {
        boolean res = false;
        if (Grille[x][y].presenceTrouNoir() == true) {
            Grille[x][y].supprimerTrouNoir();
            res = true;
            System.out.println("Trou noir, jeton absorbé");
            return res;
        }
        return res;
    }
    
    public boolean placerDesintegrateur(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].placerDesintegrateur();
    }
    
    public boolean supprimerDesintegrateur(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].supprimerDesintegrateur();
    }

    public boolean précenseDesintegrateur(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].presenceDesintegrateur();
    }

    public boolean supprimerJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].supprimerJeton();
    }

    public Jeton recupererJeton(int uneligne, int unecolonne) {
        return Grille[uneligne][unecolonne].recupererJeton();
    }
}
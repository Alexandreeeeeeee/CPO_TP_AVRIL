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
    
    public void tasserColonne(int c) {
        int lignes = 0;
        while (Grille[lignes][c].jetonCourant != null) {
                lignes++;
            
        }
        for (int i = lignes; i < 5; i++) {
            Grille[i][c].jetonCourant = Grille[i + 1][c].jetonCourant;
            Grille[i+1][c].jetonCourant = null;
        }
        Grille[5][c].jetonCourant = null;
    }
    
    public boolean colonneRemplie(int x) {
        boolean res = true;
        for (int i = 0; i<6; i++) {
            if (Grille[i][x-1].presenceJeton() == false) {
                res = false;
                return res;
            }
        }
        return res;
    }
    
    public boolean presenceTrouNoir(int x, int y) {
        return Grille[x-1][y-1].presenceTrouNoir() == true;
    }
    
    public boolean placerTrouNoir(int l, int c) {
        return Grille[l][c].placerTrouNoir();
    }
    
    public boolean suppprimerTrouNoir(int x, int y) {
        boolean res = false;
        if (Grille[x][y].presenceTrouNoir() == true) {
            Grille[x][y].supprimerTrouNoir();
            res = true;
            System.out.println("Votre jeton à été absorbé par un Trou noir !");
            return res;
        }
        return res;
    }
    
    public boolean placerDesintegrateur(int l, int c) {
        return Grille[l][c].placerDesintegrateur();
    }
    
    public boolean supprimerDesintegrateur(int l, int c) {
        return Grille[l][c].supprimerDesintegrateur();
    }

    public boolean précenseDesintegrateur(int l, int c) {
        return Grille[l][c].presenceDesintegrateur();
    }

    public boolean supprimerJeton(int l, int c) {
        return Grille[l][c].supprimerJeton();
    }

    public Jeton recupererJeton(int l, int c) {
        return Grille[l][c].recupererJeton();
    }
}
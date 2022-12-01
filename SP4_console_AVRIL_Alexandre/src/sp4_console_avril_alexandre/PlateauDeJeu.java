package sp4_console_avril_alexandre;

import java.util.Scanner;

public class PlateauDeJeu {
    CelluleDeGrille[][] Grille = new CelluleDeGrille[6][7];

    public PlateauDeJeu() {
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                Grille[l][c] = new CelluleDeGrille();
            }
        }
    }
         
public boolean ajouterJetonDansColonne(Jeton j, int c ){
        for (int i = 0; i<6; i++) {
            if (Grille[i][c].affecterJeton(j) == true) {
               return true;
            }
        }
        return false;
}
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
   
    public void viderGrille (){ // problème de redistribution des jetons aux joueurs 
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                Grille[l][c] = null;  
            }
        }
    }
     
public static final String TEST = "\u001B[30m"; // fond noir.
    
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
    
    // Ligne gagante 
    
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
    
// Colonne gagnante
  
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
    
// Diagonale montante gagnante  
    
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
        
// Diagonale descendante gagnante
    
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
    
    public boolean etreGagnantePourCouleur(String r) {
        if (ligneGagnantePourCouleur(r) == true || colonneGagnantePourCouleur(r) == true || diagonaleMontanteGagnantePourCouleur(r) == true || diagonaleDescendanteGagnantePourCouleur(r) == true) {
            return true;
        }
        else {
            return false;
        }
    }
}
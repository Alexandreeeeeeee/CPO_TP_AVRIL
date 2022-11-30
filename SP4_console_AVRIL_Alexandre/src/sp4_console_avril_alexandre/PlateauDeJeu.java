package sp4_console_avril_alexandre;

public class PlateauDeJeu {
    CelluleDeGrille[][] Grille = new CelluleDeGrille[6][7];

    public PlateauDeJeu(){
        for (int l = 0; l<6; l++){
            for (int c = 0; c<7; c++){
                Grille[l][c] = new CelluleDeGrille();
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton Jeton, int ligne){
        for (int i = 0; i < 6; i++) {
            if (Grille[i][ligne].presenceJeton() == true) {
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
     
public static final String TEST = "\u001B[30m";
    
    public void afficherGrilleSurConsole() {
        for (int l = 0; l<6 ; l++) {
            System.out.print("\n");
            for (int c = 0; c<7; c++) {
                System.out.print("\u001B[30m !");
                if (Grille[l][c].lireCouleurDuJeton() == "R") {
                    System.out.print("\u001B[31m");
                    System.out.print("\u001B[0m |");
                }
                else if (Grille[l][c].lireCouleurDuJeton() == "J") {
                    System.out.print("\u001B[33m");
                    System.out.print("\u001B[0m |");
                }
            }
        }
    }
    
    
    
}



    

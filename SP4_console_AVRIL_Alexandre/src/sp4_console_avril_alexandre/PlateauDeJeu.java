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
    
public int ajouterJetonDansColonne(Jeton j, int c ){
        for (int i = 5; i<6; i++) {
            if (Grille[i][c].presenceJeton() == false) {
                Grille[i][c].affecterJeton(j);
                return 0;
            }
        }return 0;
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
                if (Grille[l][c].lireCouleurDuJeton() == "Rouge") {
                    System.out.print("\u001B[31m");
                }
                else if (Grille[l][c].lireCouleurDuJeton() == "Jaune") {
                    System.out.print("\u001B[33m");
                }
            }
        }
    }

   
    
    
    
}



    

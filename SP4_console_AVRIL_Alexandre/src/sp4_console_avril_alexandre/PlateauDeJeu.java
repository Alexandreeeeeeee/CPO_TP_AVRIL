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
            if (Grille[i][ligne].presenceJeton(Jeton) == true) {
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
    
    public static final String Fond_Noir = "\u001B[30m";
    public static final String Jeton_Rouge = "\u001B[41m";
    public static final String Jeton_Jaune = "\u001B[43m";
    
    public void afficherGrilleSurConsole(){
        for (int l = 0; l<6; l++){
            System.out.println("\n");
            for (int c = 0; c<7; c++){
                if (Grille[l][c].lireCouleurDuJeton() == "Jaune"){
                    System.out.println(Jeton_Jaune + Grille[l][c]);
                }
                else if (Grille[l][c].lireCouleurDuJeton() == "Rouge"){
                    System.out.println(Jeton_Rouge + Grille[l][c]);
                }
                else System.out.println(Fond_Noir + Grille[l][c]);
            }
        }
    }
    
}


    

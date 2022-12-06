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
    
// ajout d'un jeton dans la colonne que le joueur rentre. 
         
public boolean ajouterJetonDansColonne(Joueur j, int c) {
        
        for (int i = 0; i<6; i++) {
            if (Grille[i][c].presenceJeton() == false) {
                if (Grille[i][c].presenceDesintegrateur() == true && Grille[i][c].presenceTrouNoir() == true){ // si on a les deux.
                    System.out.println("\nPresence d'un désintégrateur et d'un trou noir, désintégrateur récupéré\n");
                    Grille[i][c].supprimerDesintegrateur();
                    Grille[i][c].supprimerTrouNoir();
                    //Grille[i][c].affecterJeton(j);
                    Grille[i][c].supprimerJeton();
                    //joueurCourant.nombreDesintegrateurs++;
                    return true;
                }
                if (Grille[i][c].presenceTrouNoir() == true){ // si on en a un seul.
                    System.out.println("\nPresence d'un trou noir, Jeton absorbe\n");
                    Grille[i][c].supprimerTrouNoir();
                    //Grille[i][c].affecterJeton(j);
                    Grille[i][c].supprimerJeton();
                    return true;
                }
                if (Grille[i][c].presenceDesintegrateur() == true){ // si on en a un seul.
                    System.out.println("\nPresence d'un désintégrateur, désintégrateur récupéré\n");
                    Grille[i][c].supprimerDesintegrateur();
                    //Grille[i][c].affecterJeton(j);
                    Grille[i][c].supprimerJeton();
                    //joueurCourant.nombreDesintegrateurs++;
                    return true;
                }

                else { // s'il n'y a pas de Trous noirs ou de désintégrateurs on place juste le jeton.
                //Grille[i][c].affecterJeton(j);
                return true;
            }
        }
    }
    return false;
}

// 2 méthodes qui gèrent le statut de la grille de jeux.

    public boolean grilleRemplie(){ // on se sert de celle dans l'initialisation de la partie.
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
     
public static final String TEST = "\u001B[30m"; // création d'un fond noir qui sera utilisé ou non. Bon pas utilisé, mais 
// je voulais le laisser si jamais ( de base je voulais afficher des couleurs dans le super puissance 4 de la console).
    

// on affiche la grille dans la console 
  public void afficherGrilleSurConsole(){
        System.out.print("\n" + "|");
        for (int l = 5; l>=0; l--) {
            for (int c = 0; c< 7; c++) {
                if ("Rouge".equals(Grille[l][c].lireCouleurDuJeton())) {
                    System.out.print("|R|");
                } 
                else if ("Jaune".equals(Grille[l][c].lireCouleurDuJeton())) {
                    System.out.print("|J|");}
                else if (Grille[l][c].presenceTrouNoir() == true) {
                    System.out.print("[@]");}
                else if (Grille[l][c].presenceDesintegrateur() == true){
                    System.out.print("[D]");}
                else {
                    System.out.print(" - ");
                }
            }
            if (l > 0) {
                System.out.print("|\n|");
            }
            else if (l == 0){
                System.out.print("|");
            }
            else {
                System.out.println("");
            }
        }
        //System.out.println("\n 1  2  3  4  5  6  7");
    }
  
  // verification s'il n'y a pas les jetons d'un joueur, si oui on récupere sa couleur  vec "lireCouleurDuJeton".
    public boolean presenceJeton(int x, int y) {
        return Grille[x-1][y-1].presenceJeton();
    }
    
    public String lireCouleurDuJeton(int x, int y) {
        return Grille[x][y].lireCouleurDuJeton();
    }
    
// PARTIE QUI GERE LES VICTOIRES //   
    
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
 // maintenant, on vérifie qu'une des 4 conditions de victoire soit vrai pour que le jouer ai gagné.   
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
    
 // partie qui gère les trous noirs et désintégrateurs.
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
            System.out.println("Votre jeton à été absorbé par un Trou noir !"); // message dans la console
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
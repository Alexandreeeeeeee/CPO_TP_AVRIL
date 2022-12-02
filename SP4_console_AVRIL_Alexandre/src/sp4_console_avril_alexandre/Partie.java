
package sp4_console_avril_alexandre;

import java.util.Random;
import java.util.Scanner;

public class Partie {
    
    Joueur[] listeJoueurs = new Joueur[2];
    Joueur joueruCourant = listeJoueurs[0];
    PlateauDeJeu plateau = new PlateauDeJeu();
    
    public Partie(Joueur j1, Joueur j2){
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
    }
    
    public void attribuerCouleurAuxJoueurs(){
        int  r = (int)(Math.random()*2);
        if (r ==0){
            listeJoueurs[0].couleur = "Rouge";
            listeJoueurs[1].couleur = "Jaune";
        }
        else {
            listeJoueurs[0].couleur = "Jaune";
            listeJoueurs[1].couleur = "Rouge";
        }
    }
    
    
}


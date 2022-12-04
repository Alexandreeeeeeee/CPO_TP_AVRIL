
package sp4_console_avril_alexandre;

import java.util.Random;
import java.util.Scanner;

public class Partie {
    
    Joueur[] listeJoueurs = new Joueur[2];
    Joueur joueurCourant = listeJoueurs[0];
    PlateauDeJeu grilleJeu = new PlateauDeJeu();
    
    public Partie(Joueur j1, Joueur j2){
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
    }
    
    public void attribuerCouleurAuxJoueurs(){
        int  r = (int)(2*Math.random());
        if (r ==0){
            listeJoueurs[0].couleur = "Rouge";
            listeJoueurs[1].couleur = "Jaune";
        }
        else {
            listeJoueurs[0].couleur = "Jaune";
            listeJoueurs[1].couleur = "Rouge";
        }
    }
 
    public void initialiserPartie() {
              
        grilleJeu.viderGrille(joueurCourant , joueurCourant );
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entrer le nom du joueur 1 :");
        Joueur j1 = new Joueur(sc.nextLine());
        System.out.println("Entrer le nom du joueur 2 :");
        Joueur j2 = new Joueur(sc.nextLine());
        
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
        
        grilleJeu = new PlateauDeJeu();
        Random r = new Random();

        attribuerCouleurAuxJoueurs();
        Random couleur = new Random();
        int alea = couleur.nextInt(2);
        
        if (alea == 1) {
            joueurCourant = listeJoueurs[0];
            System.out.println(listeJoueurs[0].Nom + " commence");
        } else {
            joueurCourant = listeJoueurs[1];
            System.out.println(listeJoueurs[1].Nom + " commence");
        }

        for (int i = 0; i < 21; i++) {
            Jeton unJeton = new Jeton(listeJoueurs[0].couleur);
            listeJoueurs[0].ajouterJeton(unJeton);
            Jeton unJeton2 = new Jeton(listeJoueurs[1].couleur);
            listeJoueurs[1].ajouterJeton(unJeton2);

        }
        Random pos = new Random();
        int cpt = 0;
        
        for (int i = 0; i < 5; i++) {
            
            int l = pos.nextInt(5);
            int c = pos.nextInt(6);
            
            if (cpt < 2) {
                if (!grilleJeu.placerDesintegrateur(l, c)) {
                    cpt--;
                }
                cpt++;
            }
            if (!grilleJeu.placerTrouNoir(l, c)) {
                i--;
            }
        }
        for (int i = 0; i < 3; i++) {
            int l = pos.nextInt(5);
            int c = pos.nextInt(6);
            if (!grilleJeu.placerDesintegrateur(l, c)) {
                i--;
            }
        }
    }      
}

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
    
   public void débuterPartie() {
        
        initialiserPartie();
        String J1 = listeJoueurs[0].toString();
        String J2 = listeJoueurs[0].toString();
        
        while ((grilleJeu.etreGagnantePourCouleur(J1) == false) && (grilleJeu.grilleRemplie() == false) && (grilleJeu.etreGagnantePourCouleur(J2) == false)) {

            grilleJeu.afficherGrilleSurConsole();
            System.out.println("(1) Pour poser un jeton ?");
            System.out.println("(2) Pour désintégrer un jeton");
            System.out.println("(3) Pour récupérer un jeton");
            
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            
            while (action < 1 && action > 3) {
                System.out.println("Tu sais pas compter ? 1,2,3 ... ");
                action = sc.nextInt();
            }
            
            if (action == 2) {
                if (joueurCourant.nombreDesintegrateurs == 0) {
                    System.out.println("Il n'y a plus de désintégrateur ...");
                    
                    while (action != 1 && action != 3) {
                        System.out.println("Il faut choisir entre 1 et 3 !");
                        action = sc.nextInt();
                    }
                }
            } 
            switch (action) {
                case 1 -> {
                    
                    boolean result;
                    System.out.println("Choisis une colonne ou tu veux jouer : ");
                    int c = sc.nextInt() - 1;
                    
                    while (c < 0 || c > 6) {
                        System.out.println("Bon, arrete ca et choisi une colonne entre 1 et 6 ...");
                        c = sc.nextInt() - 1;
                    }
                    joueurCourant.nbj--;
                    int i = 0;
                    
                    while (grilleJeu.Grille[i][c].jetonCourant != null) {
                        i++;
                        if (i==5){
                            break;
                        }
                    }
                    if (grilleJeu.Grille[i][c].presenceDesintegrateur() == true) {
                        grilleJeu.Grille[i][c].placerDesintegrateur();
                        joueurCourant.nombreDesintegrateurs++;
                    }
                    
                    result = grilleJeu.ajouterJetonDansColonne(joueurCourant.reserveJeton.get(joueurCourant.nbj), c);
                    
                    while (result == false) {
                        System.out.println("La colonne est pleine, choisi-en une autre");
                        c = sc.nextInt() - 1;
                        result = grilleJeu.ajouterJetonDansColonne(joueurCourant.reserveJeton.get(joueurCourant.nbj), c);
                    }                
                    grilleJeu.afficherGrilleSurConsole();
                }

                case 2 -> {
                    System.out.println("Quelle ligne veux-tu désintégrer ? ");
                    int l2 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int c2 = sc.nextInt() - 1;
                    while (grilleJeu.Grille[l2][c2].lireCouleurDuJeton() == joueurCourant.couleur) {
                        System.out.println("C'est ton jeton ! ");
                        System.out.println("Quelle ligne jouer ? ");
                        l2 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        c2 = sc.nextInt() - 1;
                    }
                    grilleJeu.supprimerJeton(l2, c2);
                    grilleJeu.tasserColonne(c2);
                    grilleJeu.afficherGrilleSurConsole();
                    joueurCourant.nombreDesintegrateurs--;
                    
                    System.out.println("Nombre de désintégrateur : " + joueurCourant.nombreDesintegrateurs + "du " + joueurCourant);
                }

                case 3 -> {
                    System.out.println("Quelle ligne jouer ? ");
                    int l3 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int c3 = sc.nextInt() - 1;
                    while (grilleJeu.Grille[l3][c3].lireCouleurDuJeton() != joueurCourant.couleur) {
                        System.out.println("Ce n'es pas ton jeton ! ");
                        System.out.println("Quelle ligne jouer ? ");
                        l3 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        c3 = sc.nextInt() - 1;
                    }
                    grilleJeu.supprimerJeton(l3, c3);
                    grilleJeu.tasserColonne(c3);
                    grilleJeu.afficherGrilleSurConsole();
                }
            }
            
            String J = joueurCourant.toString();
            
            if (grilleJeu.etreGagnantePourCouleur(J) == false) {
                if (listeJoueurs[0] == joueurCourant) {
                    joueurCourant = listeJoueurs[1];
                    
                } else {
                    joueurCourant = listeJoueurs[0];
                }

                System.out.println("Tour suivant :" + joueurCourant.Nom);
                System.out.println("Nombre de jeton de " + joueurCourant.Nom + " est : " + joueurCourant.nbj);
                System.out.println("Nombre de désintégrateur de " + joueurCourant.Nom + " est : " + joueurCourant.nombreDesintegrateurs);
            }

        }
        System.out.println(joueurCourant.Nom + " est tellement fort ! La partie se termine ... ");
    } 
    
}
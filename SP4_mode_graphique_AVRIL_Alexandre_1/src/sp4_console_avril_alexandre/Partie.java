
package sp4_console_avril_alexandre; // l'une des classes les plus compliquée à coder
// avec l'aide des quelques camarades.

import java.util.Random;
import java.util.Scanner;

public class Partie {
    
    //ATTRIBUTS //
    Joueur[] listeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    PlateauDeJeu grilleJeu = new PlateauDeJeu();
    
    //CONSTRUCTEUR //
    public Partie(Joueur j1, Joueur j2){
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
        joueurCourant = null;
    }
    
    public void attribuerCouleurAuxJoueurs(){
        int  r = (int)(2*Math.random()); // random donne un chiffre entre 0 et 1, nous on veut un entie donc on met int
        // et x2
        if (r ==0){
            listeJoueurs[0].couleur = "Rouge";
            listeJoueurs[1].couleur = "Jaune";
        }
        else {
            listeJoueurs[0].couleur = "Jaune";
            listeJoueurs[1].couleur = "Rouge";
        }
    }
 
    // ok c'est partie on s'accroche ... 
    public void initialiserPartie() {
              
        grilleJeu.viderGrille(joueurCourant , joueurCourant ); // vidange de la grille.
        Scanner sc = new Scanner(System.in); // on utilise la méthode scanner importée pour récupérer ce que 
        // l'utilisateur rentre dans la console.
        
        System.out.println("Entrer le nom du joueur 1 :");
        Joueur j1 = new Joueur(sc.nextLine());
        System.out.println("Entrer le nom du joueur 2 :");
        Joueur j2 = new Joueur(sc.nextLine());
        
        listeJoueurs[0] = j1; // attribuation des couleurs.
        listeJoueurs[1] = j2;
        
        grilleJeu = new PlateauDeJeu(); // on créé une grille de jeu
        Random r = new Random();

        attribuerCouleurAuxJoueurs();
        Random couleur = new Random();
        int alea = couleur.nextInt(2);
        
        if (alea == 1) { // on fait commencer un des 2 joueurs aléatoirement.
            joueurCourant = listeJoueurs[0];
            System.out.println(listeJoueurs[0].Nom + " commence");
        } else {
            joueurCourant = listeJoueurs[1];
            System.out.println(listeJoueurs[1].Nom + " commence");
        }

        for (int i = 0; i < 21; i++) { // attribution des 21 jetons aux joueurs.
            Jeton unJeton = new Jeton(listeJoueurs[0].couleur);
            listeJoueurs[0].ajouterJeton(unJeton);
            Jeton unJeton2 = new Jeton(listeJoueurs[1].couleur);
            listeJoueurs[1].ajouterJeton(unJeton2);

        }
        Random pos = new Random(); // position
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
    
// Maintenant que le jeux est en place, on s'occupe de la gestion des actions des joueurs.
   public void débuterPartie() {
        Joueur J1 = listeJoueurs[0];
        Joueur J2 = listeJoueurs[1];
        
        while ((grilleJeu.etreGagnantePourCouleur(J1.couleur) == false) && (grilleJeu.grilleRemplie() == false) && (grilleJeu.etreGagnantePourCouleur(J2.couleur) == false)) {
            // tant que personne gagne la partie on fait cette boucle.
            System.out.println("---------------------"); // purement ésthétique...
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("\n\n(1) Pour poser un jeton ?"); // Petit menu d'action pour les joueurs.
            System.out.println("(2) Pour désintégrer un jeton");
            System.out.println("(3) Pour récupérer un jeton");
            ChangerJoueurCourant();
            Scanner sc = new Scanner(System.in); // récupération de l'action du joueurs en cours.
            int action = sc.nextInt();
            
            while (action < 1 && action > 3) { // on ne continu pas la suite de la fonction tant que le joueurs
                // n'a pas rentré le bon nombre. 
                System.out.println("Tu sais pas compter ? 1,2,3 ... ");
                action = sc.nextInt();
            } 
                if (action == 1){
                    boolean result;
                    System.out.println("Choisis une colonne ou tu veux jouer : ");
                    int c = sc.nextInt()-1; // -1 important pour pouvoir mettre le jeton dans la bonne colonne.
                    while (c < 0 || c > 7) { // "||" pour un "ou". //
                        System.out.println("Bon, arrete ca et choisi une colonne entre 1 et 6 ...");
                        c = sc.nextInt()-1; // -1 important pour pouvoir mettre le jeton dans la bonne colonne.
                    }
                    //joueurCourant.nbj--;
                    int i = 0;
                    while (grilleJeu.Grille[i][c].jetonCourant != null) { // passer à la colonne du dessus.
                        i++;
                        if (i==5){
                            break;
                        }
                    }
                    
                    if (grilleJeu.Grille[i][c].presenceDesintegrateur() == true) {
                        grilleJeu.Grille[i][c].placerDesintegrateur();
                        joueurCourant.nombreDesintegrateurs++;
                    }
                    
                    result = grilleJeu.ajouterJetonDansColonne(joueurCourant,c);                    
                    while (result == false) {
                        System.out.println("La colonne est pleine, choisi-en une autre");
                        c = sc.nextInt() - 1;
                    result = grilleJeu.ajouterJetonDansColonne(joueurCourant,c);                    } 
                    System.out.println("\n");
                }

                if (action == 2){ // partie qui gère les désintégrateurs.
                    if (joueurCourant.nombreDesintegrateurs == 0) {
                        System.out.println("Il n'y a plus de désintégrateur ...");
                    while (action != 1 && action != 3) {
                        System.out.println("Il faut choisir entre 1 et 3 !");
                        action = sc.nextInt();
                    }
                }
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
                    // stat qui indique les pouvoirs du joueurs.
                }

                if (action == 3){ // récupération su jeton d'un joueur.
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
            } // fin de la grosse boucle WHILE.
            
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
        } // Affichage du joueur gagnant.
            System.out.println(joueurCourant.Nom + " est tellement fort ! La partie se termine ... ");
    } 
   
   public void ChangerJoueurCourant() { // fonction qui permet de changer de joueur à chaque tours,
       // et d'afficher les jetons Rouges et Jaunes sur la grille de jeu de la console.
       if (joueurCourant == listeJoueurs[0]) {
            joueurCourant = listeJoueurs[1];
        }
        else{
            joueurCourant = listeJoueurs[0];
        }  
   }
}
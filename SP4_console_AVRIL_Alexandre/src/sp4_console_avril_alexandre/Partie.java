
package sp4_console_avril_alexandre;

import java.util.Random;
import java.util.Scanner;

public class Partie {
    
    Joueur[] listeJoueurs = new Joueur[2];
    Joueur joueruCourant = listeJoueurs[0];
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
    public void initialiserPartie(){

        grilleJeu.afficherGrilleSurConsole();
        Scanner sc = new Scanner(System.in);
        System.out.println("Indiquez la colonne ou vous voulez jouer: ");

        boolean placement = false;
            int c= -1;
                while(!placement){
		c= -1;
		String ligne = sc.nextLine();
		//vérification que la ligne est un entier entre 1 et colonne.
		try{
		c= Integer.valueOf(ligne);
                    if(c>= 1 && c <= 7){
			if(grilleJeu[c - 1][0] != '.'){
                            System.out.println("Colonne pleine, réitérez");
			} 
                        else {
			placement = true;
			}
                        }
                        else {
                            System.out.println("Nombre incorrect, réitérez");
					}	
				}
                        catch(Exception e){System.out.println("Nombre incorrect, réitérez");}	
			}
			//placement du jeton:
			int rang = 6-1;
			while(grilleJeu[c - 1][rang] != '.'){
                            rang--;
			}
			grilleJeu[c - 1][rang] = (i%2==1 ? 'X' : 'O');
    
    
}
}


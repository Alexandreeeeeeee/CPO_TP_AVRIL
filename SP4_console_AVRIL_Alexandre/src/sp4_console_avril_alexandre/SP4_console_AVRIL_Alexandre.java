package sp4_console_avril_alexandre;

public class SP4_console_AVRIL_Alexandre {

    public static void main(String[] args) {
        
        
        //Jeton test = new Jeton ("Jaune"); // Test de la classe Jeton.
        //System.out.println(test.lireCouleur()); // bon affichage de la couleur J ou R du jeton dans la console.
        
        Joueur J1 = new Joueur("Poutine");
        Joueur J2 = new Joueur("Macron");
        
        Partie p = new Partie(J1,J2);
        
        p.initialiserPartie();
        p.débuterPartie();
    } 
    
}

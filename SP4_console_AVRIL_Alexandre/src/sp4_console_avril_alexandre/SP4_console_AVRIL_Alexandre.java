package sp4_console_avril_alexandre;

public class SP4_console_AVRIL_Alexandre {

    public static void main(String[] args) {
        
        Jeton test = new Jeton ("Jaune"); // Test de la classe Jeton.
        System.out.println(test.lireCouleur()); // bon affichage de la couleur J ou R du jeton dans la console.
        
        PlateauDeJeu G = new PlateauDeJeu();
        G.ajouterJetonDansColonne(test, 3);
        G.ajouterJetonDansColonne(test, 3);
        G.ajouterJetonDansColonne(test, 3);
        G.ajouterJetonDansColonne(test, 3);
        G.afficherGrilleSurConsole();

    } 
    
}

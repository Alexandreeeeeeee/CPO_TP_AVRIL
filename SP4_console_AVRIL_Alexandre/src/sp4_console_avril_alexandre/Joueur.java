
package sp4_console_avril_alexandre;

import java.util.ArrayList;

public class Joueur {
    private String Nom;
    String couleur;
    ArrayList<Jeton> reserveJeton = new ArrayList<Jeton>();
    int nombreDesintegrateurs ; 
    int nombreJetonsRestants = reserveJeton.size();
    
    public Joueur(String a){
        Nom = a;
    }
    
    public void affecterCouleur(String b){
        couleur = b;
    }
    
    public void lireCouleur(String c){
        couleur = c;
    }
    
    public void ajouterJeton(Jeton jeton){
        reserveJeton.add(jeton);
    }

    @Override
    
    public String toString() {
        return this.Nom;
    }
    
}

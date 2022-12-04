
package sp4_console_avril_alexandre;

import java.util.ArrayList;

public class Joueur {
    String Nom;
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
      
    public int nombreDeJetons(){
        int nb = reserveJeton.size(); 
        return nb;
    }
    
    public void ajouterJeton(Jeton jeton){
        reserveJeton.add(jeton);
    }

     public void obtenirDesintegrateur() {
        nombreDesintegrateurs++;
    }
    
    public boolean utiliserDesintegrateur() {
        if (nombreDesintegrateurs==0){
            return false;
        }
        else{
            nombreDesintegrateurs=nombreDesintegrateurs-1;
            return true;
        }
    }
    
    @Override
    
    public String toString() {
        return this.Nom;
    }
    
}

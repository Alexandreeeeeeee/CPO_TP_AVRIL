
package sp4_console_avril_alexandre;

import java.util.ArrayList;

public class Joueur {
    
    //ATTRIBUTS //
    String Nom;
    String couleur;
    ArrayList<Jeton> reserveJeton = new ArrayList<Jeton>();
    int x;
    int nombreDesintegrateurs ; 
    int nombreJetonsRestants = reserveJeton.size();
    int nbj;
    
    //CONSTRUCTEUR //
    public Joueur(String a){
        Nom = a;
    }
    
    public void affecterCouleur(String b){
        couleur = b;
    }
      
    public int nombreDeJetons(){
        nbj = reserveJeton.size(); 
        return nbj;
    }
    
    public void ajouterJeton(Jeton jeton){
        reserveJeton.add(jeton); // ajout de jeton à la collection.
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
        return this.Nom; // on retourne le nom du joueur
    }
    
}

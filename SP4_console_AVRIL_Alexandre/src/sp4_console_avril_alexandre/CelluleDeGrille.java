package sp4_console_avril_alexandre;

public class CelluleDeGrille {
    Jeton jetonCourant;
    private boolean avoirTrouNoir;
    boolean avoirDesintegrateur;
    
    public CelluleDeGrille () {
        jetonCourant = null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;
    }
    
    public boolean presenceJeton() {
        if (jetonCourant == null) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean affecterJeton(Jeton J){
        if (jetonCourant == null) {
            jetonCourant = J;
            return true;
        } 
        else {
            return false;
        }
    }
    public String lireCouleurDuJeton() {
            if(jetonCourant != null) {
                return jetonCourant.lireCouleur();
            }
            else {
                return "vide";
            }
        }
public Jeton recupererJeton() {
        if (jetonCourant != null) {
            Jeton jetontmp = jetonCourant;
            jetonCourant = null;
            return jetontmp;
        }
        else {
            return (null);
        }
    }
    
@Override
    public String toString() {
        if (this.presenceJeton() == true) {
            if (this.jetonCourant.lireCouleur() == "Rouge") {
                return "R";
            }
            else {
                return "J";
            }
        }
        return null;
    }
}
    /*public boolean placerTrouNoir(){
        if (avoirTrouNoir == false){
            avoirTrouNoir = true;
            System.out.print("Un trou noir a été ajouté !");
            return true;
        }
        else{
            return false;
        }
        }
    public boolean supprimerTrouNoir(){
        if (avoirTrouNoir == true){
            avoirTrouNoir = false;
            return false;
        }
        else {
            return true;
        }
    }
    public boolean presenceTrouNoir(){
    if (avoirTrouNoir == false) {
            return false;
        }
        else {
            return true;
        
    }
}*/
        

        
    
    
        
    


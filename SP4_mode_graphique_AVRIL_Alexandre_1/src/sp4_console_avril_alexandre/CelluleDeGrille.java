package sp4_console_avril_alexandre;

public class CelluleDeGrille {
    Jeton jetonCourant;
    boolean avoirTrouNoir;
    boolean avoirDesintegrateur;
    
    public CelluleDeGrille () { // initialisation 
        jetonCourant = null;
        //avoirTrouNoir = false;
        //avoirDesintegrateur = false;
    }
    
    public boolean presenceJeton() {
        if (jetonCourant == null) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean affecterJeton(Jeton J) {
        if(jetonCourant == null){
            jetonCourant = J;
            return true;
        }
        return false;
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
public boolean supprimerJeton() {
        if (jetonCourant == null) {
            return false;
        } else {
            jetonCourant = null;
            return true;
        }
}
    
@Override // méhode ToString

    public String toString() {
        if (this.presenceJeton() == true) {
            if (this.jetonCourant.lireCouleur() == "Rouge") {
                return "R";
            }
            else {
                return "J";
            }}
            if (this.avoirTrouNoir == true) {
            return "@";
        }
        if (this.avoirDesintegrateur == true && this.avoirTrouNoir == false) {
            return "D";
        }
        else {
            return ".";
    }}

// Gestion des Désintégrateurs et trous noirs. 
// Avec bouléen.
    
    public boolean placerTrouNoir(){
        if (avoirTrouNoir == false){
            avoirTrouNoir = true;
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
}

public boolean placerDesintegrateur() {
        if (avoirDesintegrateur == false) {
            avoirDesintegrateur = true;
            return true;
        } else {
            return false;
        }

    }
    // présence désintégrateurs.
    public boolean presenceDesintegrateur() {
        if (avoirDesintegrateur == false) {
            return false;
        } else {
            return true;
        }
    }

    // supprime le désintégrateur présent de la cellule
    public boolean supprimerDesintegrateur() {
        if (avoirDesintegrateur == true) {
            avoirDesintegrateur = false;
            System.out.println("Suppression du desintegrateur effectué");
            return true;
        } else {
            System.out.println("pas de desintegrateur present");
            return false;
        }
    }
    
    // rend les trous noirs opértionnels.
    public boolean activerTrouNoir() {
        if (avoirTrouNoir == true) {
            jetonCourant = null; // vide la cellule
            avoirTrouNoir = false; // disparition du Trou Noir
            System.out.println("Activation du Trou Noir");
            return true;
        } else {
            System.out.println("Pas de Trou Noir dans cette cellule");
            return false;
        }
    }
    
}
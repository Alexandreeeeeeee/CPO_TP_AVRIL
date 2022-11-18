package sp4_console_avril_alexandre;

public class CelluleDeGrille {
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    boolean avoirDesintegrateur;
    
    public CelluleDeGrille () {
        jetonCourant = null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;
    }
    
    public boolean presenceJeton(Jeton Jeton) {
        if (jetonCourant == null) {
            jetonCourant = Jeton;
            return false;
        }
        else {
            System.out.print("La cellule est pleine !");
            return true;
        }
    }
    public String lireCouleurDuJeton() { // lecteur d'une case, elle indique la couleur du jeton, ou rien.
        if (jetonCourant == null) {
            return "vide";
        } 
        else {
            return jetonCourant.lireCouleur();
        }
    }
}
    //public boolean placerTrouNoir(){
        //if (avoirTrouNoir == false){
            //avoirTrouNoir = true;
            //System.out.print("Un trou noir a été ajouté !");
            //return true;
        //}
        //else{
            //return false;
        //}
        //}
    //public boolean supprimerTrouNoir(){
        //if (avoirTrouNoir == true){
            //avoirTrouNoir = false;
            //return false;
        //}
        //else {
            //return true;
        //}
    //}
    //public boolean presenceTrouNoir(){
    //if (avoirTrouNoir == false) {
            //return false;
        //}
        //else {
            //return true;
       // 
    //}
//}
        

        
    
    
        
    


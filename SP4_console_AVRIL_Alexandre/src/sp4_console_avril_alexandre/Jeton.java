package sp4_console_avril_alexandre;

public class Jeton {
    
    private String couleur ; //déclaration attribut couleur en privé.
    
    public Jeton(String unecouleur){
        couleur = unecouleur; // affectation de la couleur au jeton.
    }
    public String lireCouleur(){
        return couleur; // on renvoie la couleur du jeton.
    }
    
    @Override
    public String toString() { // méthode d'affichage 

    String c ;
    if (couleur == "rouge");
        c = ("R");
    if (couleur == "jaune");
        c = ("J");
    return c;
}
    
}

    





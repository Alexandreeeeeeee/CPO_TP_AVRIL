/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_bieres_avril ;
/**
 *
 * @author alexa
 */
public class BouteilleBiere { //Création des variables de la classe BouteilleBiere
    
    String Nom ; 
    Double degresAlcool ; 
    String brasserie ; 
    Boolean ouverte ;
    
    public void lireEtiquette () {
        System.out.println("Bouteille de " + Nom +" (" +degresAlcool +"degres) \nBrasserie : " + brasserie ) ;
}
}
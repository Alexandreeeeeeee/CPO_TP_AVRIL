/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_bieres_avril;

/**
 *
 * @author alexa
 */
public class TP2_Bieres_AVRIL {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BouteilleBiere uneBiere = new BouteilleBiere() ;
        uneBiere.Nom = "Cuvée des trolls";
        uneBiere.degresAlcool = 7.0 ;
        uneBiere.brasserie = "Dubuisson" ; 
        uneBiere.ouverte = false ; 
        //uneBiere.lireEtiquette() ; 
        
        BouteilleBiere Biere_2 = new BouteilleBiere() ;
        Biere_2.Nom = "Leffe";
        Biere_2.degresAlcool = 6.0 ;
        Biere_2.brasserie = "Abbaye de Leffe" ; 
        //Biere_2.lireEtiquette() ;
        
        BouteilleBiere Biere_3 = new BouteilleBiere() ;
        Biere_3.Nom = "Desperados";
        Biere_3.degresAlcool = 3.6 ;
        Biere_3.brasserie = " Brasserie de l'Espérance" ; 
        Biere_3.lireEtiquette() ;
}
}

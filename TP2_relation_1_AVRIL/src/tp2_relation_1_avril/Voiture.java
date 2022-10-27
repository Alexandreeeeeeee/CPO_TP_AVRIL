package tp2_relation_1_avril;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Voiture {
   
    String Modele;
    String Marque;
    int PuissanceCV;
    Personne proprietaire; // rajout d'une variable propriétaire de type personne que fera référence à la personne qui appartient la voiture.
    
    public Voiture (String unModele, String uneMarque, int unePuissance) {
        
        Modele = unModele;
        Marque = uneMarque;
        PuissanceCV = unePuissance;  
    }
   
    @Override // Affichage 
    public String toString () {
        return(Marque + " " + Modele);
    }
}

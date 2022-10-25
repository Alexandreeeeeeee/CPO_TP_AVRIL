package tp2_relation_1_avril;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Voiture {
    
    String Modele ; 
    String Marque ; 
    int PuissanceCV ;
    String Voiture ; 
    
public Voiture (String UnModele, String UneMarque, int UnePuissance) {
    Modele = UnModele ;
    Marque = UneMarque ;
    PuissanceCV = UnePuissance ; 
}

@Override

public String toString () {
 return Voiture;
}
}

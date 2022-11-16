/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

/**
 *
 * @author alexa
 */
public class Epée extends Arme {
    int indice; 
    
    public Epée(String n, int i, int a){
        super(n, i);
        if (a > 100) indice = 99;
        else indice = a;
    }
    
    public int GetIndice () {
        return indice;
    }
 @Override

public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Votre arme se nomme " + Nom + " et est de niveau d'attaque " + NivAttaque + " est de finesse "+ indice);
    return chaine_a_retourner ;   
}}

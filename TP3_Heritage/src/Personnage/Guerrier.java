package Personnage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexa
 */
public class Guerrier extends Personnage {
    String a;
    
    public Guerrier (String n, int i, boolean c){ 
        super(n, i);  
        if (c == true) a = "à cheval";
        
        else a = "à pied";
    }
@Override

public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Il s'appelle " + Nom + " et a un niveau de vie de " + NivVie + ", il est " + a);
    return chaine_a_retourner ;   
}}

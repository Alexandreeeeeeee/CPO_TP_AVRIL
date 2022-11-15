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
    boolean Acheval;
    
    public Guerrier (String n, int i, boolean a){
        super(n, i);  
        a = Acheval;
        if (a = true) Acheval = a;
        
        else Acheval = a;
    }
@Override

public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Il s'appelle " + Nom + " et a un niveau de vie de " + NivVie + ", il est à cheval : " + Acheval);
    return chaine_a_retourner ;   
}}

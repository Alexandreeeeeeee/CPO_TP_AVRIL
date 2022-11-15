package Personnage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexa
 */
public class Magicien extends Personnage {
    boolean Confirme;
    
    public Magicien (String n, int i, boolean a) {
        super(n, i);
        a = Confirme;
        if (a = true) Confirme = a;
        
        else Confirme = a;
    }
@Override

public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Il s'appelle " + Nom + " et a un niveau de vie de " + NivVie + ", il est confirmé : " + Confirme);
    return chaine_a_retourner ;   
}}

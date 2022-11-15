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
    String a;
    
    public Magicien (String n, int i, boolean c) {
        super(n, i);
        if (c == true) a = "confirmé";
        
        else a = "novice";
    }
@Override

public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Il s'appelle " + Nom + " et a un niveau de vie de " + NivVie + ", il est" + a);
    return chaine_a_retourner ;   
}}

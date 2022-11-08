package Armes;

import Armes.Arme;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexa
 */
public class Baton extends Arme {
    int age;
    
    public Baton (String n, int i, int a) {
        super(n, i);
        if (a > 100) age = 99;
        else age = a ;
    }
@Override

public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Votre arme se nomme " + Nom + " et est de niveau d'attaque " + NivAttaque + " est de finesse " + age);
    return chaine_a_retourner ;
}}

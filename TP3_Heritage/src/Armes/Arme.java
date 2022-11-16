package Armes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Personnage.Personnage;
/**
 *
 * @author alexa
 */
public class Arme {
    public String Nom;
    int NivAttaque;
    
    public Personnage proprietaire;
    
   public Arme(String n, int i){
       Nom = n;
       NivAttaque = i;
   }   

}

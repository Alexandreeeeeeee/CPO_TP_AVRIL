/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3_heritage;

/**
 *
 * @author alexa
 */
public class TP3_Heritage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Epée arme1 = new Epée ("Excalibur", 7,5); // déclaration des 2 épées et batons de la classe Arme.
        Epée arme2 = new Epée ("Durandal", 4,7);
        Baton arme3 = new Baton ("Chêne",4,5);
        Baton arme4 = new Baton ("Charme", 5,6);
        
        System.out.println(arme1); // affichage dans la console
        System.out.println(arme2);
        System.out.println(arme3);
        System.out.println(arme4);

    }   
}

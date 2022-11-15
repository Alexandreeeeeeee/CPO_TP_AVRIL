/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3_heritage;

/**
 *
 * @author alexa
 */
import Personnage.Guerrier;
import Personnage.Magicien;
import Personnage.Personnage;
import Armes.Epée;
import Armes.Baton;
import Armes.Arme;
import java.util.ArrayList;

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
        
        ArrayList<Arme> Tab = new ArrayList<Arme>(); // attention à bien mettre entre triangle pas un type de variable mais le nomde la classe qu'on stock.
        Tab.add(arme1);
        Tab.add(arme2);
        Tab.add(arme3);
        Tab.add(arme4);
        System.out.println(Tab);
        
        int TailleTab = Tab.size(); // récupération de la taille du talbeau dynamqiue avec la méthode .size()
        System.out.println("La taille du tableau dynamique est de " + TailleTab);
        
        Magicien perso1 = new Magicien ("Gandalf", 65, true );
        Magicien perso2 = new Magicien ("garcimore", 44,false);
        Guerrier perso3 = new Guerrier ("Conan",78, false);
        Guerrier perso4 = new Guerrier ("Lannister", 45, true); 
        
        System.out.println(perso1); // affichage dans la console
        System.out.println(perso2);
        System.out.println(perso3);
        System.out.println(perso4);
        
        ArrayList<Personnage> Tab2 = new ArrayList<Personnage>(); // attention à bien mettre entre triangle pas un type de variable mais le nomde la classe qu'on stock.
        Tab2.add(perso1);
        Tab2.add(perso2);
        Tab2.add(perso3);
        Tab2.add(perso4);
        System.out.println(Tab2);
    }   

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_convertisseur_avril;

import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class TP1_CONVERTISSEUR_AVRIL {

    static Scanner sc = new Scanner(System.in); // déclaration du scanner.
    
    public static void main(String[] args) {
        System.out.println("\nEntrer une températeur à convertir : "); // demande à l'utilisateur.
        Double Temp = sc.nextDouble(); // stock le choix de l'utilisateur.
        System.out.println("(1) Celcius en Kelvin \n (2) Kelvin en Celcius \n (3) Farenheit en Celcius \n (4) Celcius en Farenheit \n (5) Farenheit en Kelvin \n (6) Kelvin en Farenheit");
        Double rep = sc.nextDouble();
    }
        if (rep == 1) {
            c.CelciusVersKelvin() ;  
            c.toString() ;
        }
        if (rep == 2) {
            c.KelvinVersCelcius () ; 
            c.toString() ;
    }
        if (rep == 3) {
            c.FarenheitVersCelcius () ;
            c.toString() ;
    }
        if (rep == 4) {
            c.CelciusVersFarenheit () ;
            c.toString() ;
}
        if (rep == 5) {
            c.FarenheitVersKelvin () ; 
            c.toString() ;
}
        if (rep == 6) {
            c.KelvinVersFarenheit () ;
            c.toString() ;
            
}
}
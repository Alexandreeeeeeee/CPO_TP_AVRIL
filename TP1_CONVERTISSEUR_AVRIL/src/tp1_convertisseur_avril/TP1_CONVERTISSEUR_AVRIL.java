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


    
    public static void main(String[] args) {
        
        Convertisseur c = new Convertisseur () ; 
        
        Scanner sc;
        sc  = new Scanner (System.in) ;
        
        System.out.println("\nEntrer une températeur à convertir : "); // demande à l'utilisateur.
        int Temp = sc.nextInt(); // stock le choix de l'utilisateur.
        System.out.println("\n Quelle conversion voulez effectuer ? \n\n (1) Celcius en Kelvin \n (2) Kelvin en Celcius \n (3) Farenheit en Celcius \n (4) Celcius en Farenheit \n (5) Farenheit en Kelvin \n (6) Kelvin en Farenheit\n");
        int rep = sc.nextInt();
    
        if (rep == 1) {
            c.CelciusVersKelvin(Temp) ;  
            c.toString() ;
        }
        if (rep == 2) {
            c.KelvinVersCelcius (Temp) ; 
            c.toString() ;
        }
        if (rep == 3) {
            c.FarenheitVersCelcius (Temp) ;
            c.toString() ;
        }
        if (rep == 4) {
            c.CelciusVersFarenheit (Temp) ;
            c.toString() ;
        }
        if (rep == 5) {
            c.FarenheitVersKelvin (Temp) ; 
            c.toString() ;
        }
        if (rep == 6) {
            c.KelvinVersFarenheit (Temp) ;
            c.toString() ;    
        }
    }}
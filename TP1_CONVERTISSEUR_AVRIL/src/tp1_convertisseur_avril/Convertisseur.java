package tp1_convertisseur_avril;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Convertisseur {
    // On définit les attributs de la classe BouteilleBiere.
    Double nbConversions ; 
    
public void Convertisseur () {

}
public void CelciusVersKelvin (double temp) {
        double kelvin ;
        kelvin = temp + 273.15 ;
        System.out.println("Votre valeur vaut " + kelvin+ " degrés Kelvins");
}

public void KelvinVersCelcius (double temp) {
    double Celcius ;
    Celcius = temp - 273.15 ;
    System.out.println("Votre valeur vaut " + Celcius+ " degrés Celcius");
}

public void FarenheitVersCelcius(double temp) {
    double Celcius ;
    Celcius = (temp - 32) * 5/9 ;
    System.out.println("Votre valeur vaut " + Celcius+ " degrés Celcius");
}

public void CelciusVersFarenheit(double temp) {
    double Farenheit ;
    Farenheit = (temp*9/5) + 32 ;
    System.out.println("Votre valeur vaut " + Farenheit+ " degrés Farenheit");
}

public void FarenheitVersKelvin(double temp) {
    double Kelvin ;
    Kelvin = (temp - 32) * 5/9 + 273.15 ;
    System.out.println("Votre valeur vaut " + Kelvin+ " degrés Kelvin");
}

public void KelvinVersFarenheit(double temp) {
    double Farenheit ;
    Farenheit = (temp - 273.15) * 9/5 + 32 ;
    System.out.println("Votre valeur vaut " + Farenheit+ " degrés Farenheit");
}
    
public String toString(double temp) {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Voici votre conversion ;" + temp);
    return chaine_a_retourner ;
}}

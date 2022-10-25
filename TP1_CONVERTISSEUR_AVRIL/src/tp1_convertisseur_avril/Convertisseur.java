package tp1_convertisseur_avril;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Convertisseur {
    // On définit les attributs de la classe Convertisseur.
    int nbConversions ; // ne pas mettre dans le constructeur sinon sera variable locale.
public Convertisseur () {
        nbConversions = 0 ;
    }

public void CelciusVersKelvin (double temp) {
    double kelvin ;
    kelvin = temp + 273.15 ;
    nbConversions += 1 ;
    System.out.println("Votre valeur vaut " + kelvin+ " degrés Kelvins");
}

public void KelvinVersCelcius (double temp) {
    double Celcius ;
    Celcius = temp - 273.15 ;
    nbConversions += 1 ;
    System.out.println("Votre valeur vaut " + Celcius+ " degrés Celcius");
}

public void FarenheitVersCelcius(double temp) {
    double Celcius ;
    Celcius = (temp - 32) * 5/9 ;
    nbConversions += 1 ;
    System.out.println("Votre valeur vaut " + Celcius+ " degrés Celcius");
}

public void CelciusVersFarenheit(double temp) {
    double Farenheit ;
    Farenheit = (temp*9/5) + 32 ;
    nbConversions += 1 ;
    System.out.println("Votre valeur vaut " + Farenheit+ " degrés Farenheit");
}

public void FarenheitVersKelvin(double temp) {
    double Kelvin ;
    Kelvin = (temp - 32) * 5/9 + 273.15 ;
    nbConversions += 1 ;
    System.out.println("Votre valeur vaut " + Kelvin+ " degrés Kelvin");
}

public void KelvinVersFarenheit(double temp) {
    double Farenheit ;
    Farenheit = (temp - 273.15) * 9/5 + 32 ;
    nbConversions += 1 ;
    System.out.println("Votre valeur vaut " + Farenheit+ " degrés Farenheit");
}
    
@Override
public String toString () {
    return "nb de conversions: "+ nbConversions;
}
}
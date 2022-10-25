package tp1_convertisseur_avril;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Convertisseur {
    // On définit les attributs de la classe BouteilleBiere.
    Double nbConversions ; 
    
public void Convertisseur () {
    Convertisseur c = new Convertisseur () ; 
}
public void CelciusVersKelvin () {
        double kelvin ;
        Kelvin = temp + 273.15 ;
        return Kelvin ;
}

public void KelvinVersCelcius () {
    double Celcius ;
    Celcius = temp - 273.15 ;
    return Celcius ;
}

public void FarenheitVersCelcius() {
    double Celcius ;
    Celcius = (temp - 32) * 5/9 ;
    return Clecius ;
}

public void CelciusVersFarenheit() {
    double Farenheit ;
    Farenheit = (temp*9/5) + 32 ;
    return Farenheit ;
}

public void FarenheitVersKelvin() {
    double Kelvin ;
    Kelvin = (temp - 32) * 5/9 + 273.15 ;
    return Kelvin ;
}

public void KelvinVersFarenheit() {
    double Farenheit ;
    Farenheit = (temp - 273.15) * 9/5 + 32 ;
    return Farenheit ;
    
public String toString() {

    String chaine_a_retourner ;
    chaine_a_retourner = ("Voici votre conversion ;" + temp);
    return chaine_a_retourner ;
}}

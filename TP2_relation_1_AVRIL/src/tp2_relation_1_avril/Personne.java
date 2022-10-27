package tp2_relation_1_avril;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Personne {
    
    String Nom ;
    String Prenom ;
    int nbVoitures; 
    Voiture [] liste_voitures ; // on ajoute la liste de voiture dans la class Personne car ce sont les personne a qui on attribuera les voitures.
    
public Personne (String UnNom, String UnPrenom) {
    
    Nom = UnNom ; 
    Prenom = UnPrenom ;
    liste_voitures = new Voiture [3]; // création d'un tableau répertoriant les 3 voitures.
    nbVoitures = 0; // initialisation à 0   
}

@Override
public String toString () {
    return(Nom + " " + Prenom);
}
public boolean ajouter_voiture( Voiture voiture_a_ajouter) {
        if (voiture_a_ajouter.proprietaire!=null){
            System.out.println("Voiture volé elle appartient déjà à quelqu'un ");
            return false;}
            
        else if (nbVoitures==3){
            System.out.println("Trop de voiture ");
        return false ;
        }
       liste_voitures[nbVoitures]=voiture_a_ajouter;
       nbVoitures+=1;
       voiture_a_ajouter.proprietaire = this ;
       System.out.println("La voiture ajouté est : "+voiture_a_ajouter);
// cela dit à la voiture que l'objet qui utilise la methode ajouter_voiture est son proprietaire  
       return true ; 
    }    
}


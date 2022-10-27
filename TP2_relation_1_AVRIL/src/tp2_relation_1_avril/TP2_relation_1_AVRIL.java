/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_relation_1_avril;

public class TP2_relation_1_AVRIL {

    public static void main(String[] args) {
        
        // Initialisation de 4 voitures différentes. + Les 2 noouvelles voitures qui seront utilisées aprés 
        
        Voiture uneClio = new Voiture ("Clio", "Renault", 5 ) ;
        Voiture uneAutreClio = new Voiture ("Clio", "Renault", 5 ) ;
        Voiture une2008 = new Voiture ("2008", "Peugeot", 6 ) ;
        Voiture uneMicra = new Voiture ("Micra", "Nissan", 4 ) ;
        Voiture uneMustang = new Voiture ("Mustang", "Ford", 10 ) ;
        Voiture Agera = new Voiture ("Agera", "Konigzeg", 23 ) ;
        
        // initialisation de 2 personnes différentes.
        
        Personne bob = new Personne("Bobby", "Sixkiller");
        Personne reno = new Personne("Reno", "Raines");
        
        System.out.println("liste des voitures disponibles :\n"+ uneClio + 
        "\n" + uneAutreClio + "\n" + une2008 + "\n" + uneMicra ) ;

        bob.liste_voitures[0] = uneClio;
        bob.nbVoitures += 1; // permet de visualiser les nb de voitures qu'a bob et reno
        uneClio.proprietaire = bob;
        bob.liste_voitures[1] = uneMicra;
        bob.nbVoitures +=1;
        uneMicra.proprietaire = bob;
        
        // affichage dans la console de qui à quoi ...
        System.out.println("la premiere voiture de Bob est une " + bob.liste_voitures[0] ) ;
        System.out.println("la deuxieme voiture de Bob est une " + bob.liste_voitures[1] ) ;
        System.out.println("\n");
        
        // meme procédure que pour BOB.
        reno.liste_voitures[0] = uneAutreClio;
        reno.nbVoitures += 1;
        uneAutreClio.proprietaire = reno;
        reno.liste_voitures[1] = une2008;
        reno.nbVoitures += 1;
        une2008.proprietaire = reno;
        
        System.out.println("la premiere voiture de Reno est une " + reno.liste_voitures[0] ) ;
        System.out.println("la deuxieme voiture de Reno est une " + reno.liste_voitures[1] ) ;
        System.out.println("\n");
        
        // ajout de nouvelles voitures à BOb, attention à bien les déclarer avant grace à la méthode dans Personne.
        bob.ajouter_voiture(Agera);
        bob.ajouter_voiture(uneMustang);
        bob.ajouter_voiture(uneAutreClio);
        
        // affichage final.
        System.out.println("\n");
        System.out.println("la premiere voiture de Bob est une " + bob.liste_voitures[0] ) ;
        System.out.println("la deuxieme voiture de Bob est une " + bob.liste_voitures[1] ) ;
        System.out.println("la troisieme voiture de Bob est une " + bob.liste_voitures[2] ) ;
    }
   
}   

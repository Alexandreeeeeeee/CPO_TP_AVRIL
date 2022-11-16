package Personnage;

import Armes.Arme;
import java.util.ArrayList;

public class Personnage {
    public String Nom;
    int NivVie;
    ArrayList<Arme> inventaire = new ArrayList<Arme>();
    Arme Arme_en_main = null;
    public static int nbperso;
    
       public Personnage(String n, int i){
       Nom = n;
       NivVie = i;
}
       
@Override

    public String toString() {
        // La méthode toString() permet de retourner la chaine de caractère que l’on veut afficher quand l’objet est cité
        String chaine_a_retourner ;
        chaine_a_retourner = "personnage: "+ Nom + "\n" + "niveau de vie: " + NivVie;
        return chaine_a_retourner ;
    }

    public int Vie() {
        return NivVie;
    }
    
    public void Ajouter_Arme(Arme Arme_a_ajouter) {
        
        if (Arme_a_ajouter.proprietaire != null) {
            System.out.println(Arme_a_ajouter.Nom + " appartiens déjà à " + Arme_a_ajouter.proprietaire.Nom + " elle ne peut donc pas être associée à " + this.Nom);
        }
        
        else {
        if (inventaire.size()<5) {
            this.inventaire.add(Arme_a_ajouter);
            Arme_a_ajouter.proprietaire = this;
            System.out.println(Arme_a_ajouter + " a bien été ajoutée à " + this.Nom);
        }
        else {
            System.out.println(this.Nom + " possède déjà 5 armes");
        }
        }
        
    }
    
    // Méthode qui permet d'ajouter une arme à l'inventaire d'un personnage
    
    
    public void Equiper_Arme(String nomArme) {
        for (int z = 0; z < this.inventaire.size(); z++) {
            if (inventaire.get(z).Nom == nomArme) {
                Arme_en_main = inventaire.get(z);
                System.out.println(inventaire.get(z).Nom + " a bien été saisi par " + this.Nom);
            }
        }
    }
}




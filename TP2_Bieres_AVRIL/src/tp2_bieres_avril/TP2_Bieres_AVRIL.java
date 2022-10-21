/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_bieres_avril;

/**
 *
 * @author alexa
 */
public class TP2_Bieres_AVRIL {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       BouteilleBiere uneBiere = new BouteilleBiere("Cuvee des Trolls", 7.0, "Dubuisson");
       //uneBiere.Nom = "Cuvee des Trolls";
       //uneBiere.degreAlcool = 7.0;
       //uneBiere.brasserie = "Dubuisson";
       //uneBiere.ouverte = false;
       uneBiere.ouverte = false;
       uneBiere.lireEtiquette();

       System.out.println(uneBiere);
       System.out.println("\n");

       BouteilleBiere uneBiere2 = new BouteilleBiere("leffe", 6.6, "Abbaye de Leffe");
       //uneBiere2.Nom = "leffe";
       //uneBiere2.degreAlcool = 6.6;
       //uneBiere2.brasserie = "Abbaye de Leffe";
       uneBiere2.ouverte = true;
       uneBiere2.lireEtiquette();
       uneBiere2.Décapsuler();

       System.out.println(uneBiere2);
       System.out.println("\n");
       
       BouteilleBiere Biere1664 = new BouteilleBiere("1664", 5.2, "Latour");

       Biere1664.Décapsuler();
       Biere1664.lireEtiquette();
       
       System.out.println(Biere1664);
       System.out.println("\n");
     
       BouteilleBiere BiereDesperados = new BouteilleBiere("Desperados", 6.2, "IO");

       BiereDesperados.lireEtiquette();
       
       System.out.println(BiereDesperados);     
       System.out.println("\n");

       BouteilleBiere BiereSkoll = new BouteilleBiere("Skoll", 8.0, "Leviatan");

       BiereSkoll.Décapsuler();
       BiereSkoll.lireEtiquette();

       System.out.println(BiereSkoll);
       
    }

}


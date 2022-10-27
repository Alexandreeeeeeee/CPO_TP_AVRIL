/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_manip_avril;

public class TP2_manip_AVRIL {

    public static void main(String[] args) {
        Tartiflette assiette1 = new Tartiflette(500) ;
        Tartiflette assiette2 = new Tartiflette(600) ;
        Tartiflette assiette3 = assiette2 ; 
        
        // il y a en tout 2 tartiflettes différentes pour 3 variables créé, donc 2 tartiflettes sont réellement crées.
        // assiette2 et assiette3 référencent la meme tartiflette mais ce sont 2 variables différentes ...
        
        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);
        System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories);
        
        // aprés affichage on voit bien que assiette 2 et assiette 3 ont le meme nb de calories.
        
        assiette2 = assiette1 ;
        assiette1 = assiette3 ; 
        
        //System.out.println(assiette1.nbCalories) ;
        //System.out.println(assiette2.nbCalories) ; affichage pour tester si l'inversion à fonctionner.
        
        // Moussaka assiette666 = assiette1 ; 
        // Moussaka assiette667 = new Tartiflette () ; 
        // Ces lignes sont fausses car on ne peut pas référencer un type objet qui n'a aucun rapport avec ce qu'on annonce,
        // ici, les class Tartiflette et Moussaka sont indépendantes.
        
        Moussaka [] tab = new Moussaka [10];
        
        for (int i = 0;i<10;i++){
            tab[i] = new Moussaka(100+i);
            System.out.println(tab[i]);
            }
}

        }
// on s'aide d'une boucle for pour pouvoir créer le tableau de 10 Moussakas et leur assigner une valeur en calories.
// bien déclarer le tableaa juste avant.
package tp3_heritage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexa
 */
public class Baton extends Arme {
    int age;
    
    public Baton (String n, int i, int a) {
        super(n, i);
        if (a > 100) age = 99;
        else age = a ;
    }
    
}

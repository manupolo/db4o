/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

/**
 *
 * @author Manuel
 */
public class prueba {
    public static void main(String[] args) {
        
        metodosCantante mc = new metodosCantante();
        
        mc.añadirCantante("Alexio", "Regueton");
        mc.añadirCantante("Ñengo", "Regueton");
        mc.añadirCantante("Malú", "Pop");
        mc.añadirCantante("Camarón", "Flamenco");
        
    }
}

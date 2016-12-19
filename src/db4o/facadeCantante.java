/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel
 */
public class facadeCantante {
    
    metodosCantante mc = new metodosCantante();
    
    public void añadirCantante(String nombre, String estilo){
        mc.añadirCantante(nombre, estilo);
    }
    
    public void eliminarCantante(String nombre){
        mc.eliminarCantante(nombre);
    }
    
    public void modificarCantante(String nombre, String estilo){
        mc.modificarCantante(nombre, estilo);
    }
    
    public DefaultTableModel getCantantes(){
        return mc.getCantantes();
    }
}

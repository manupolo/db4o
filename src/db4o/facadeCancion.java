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
public class facadeCancion {
    metodosCanciones mc = new metodosCanciones();
    
    public DefaultTableModel getCanciones(){
        return mc.getCanciones();
    }
    
    public void añadirCancion(String titulo, String nomCantante, String duracion){
        mc.añadirCancion(titulo, nomCantante, duracion);
    }
    
    public void modificarCancion(String titulo, String titulo2, String nomCantante, String duracion){
        mc.modificarCancion(titulo, titulo2, nomCantante, duracion);
    }
    
    public void eliminarCancion(String titulo){
        mc.eliminarCancion(titulo);
    }
}

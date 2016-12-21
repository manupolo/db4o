/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class facadeMultimedia {
    metodosMultimedia mm = new metodosMultimedia();
    
    public DefaultTableModel getCancionesCantante(String titulo){
        return mm.listarCancionesporTitulo(titulo);
    }
    
    public DefaultTableModel getCancionesDuracion(String duracion, String duracion2){
        return mm.listarCancionesporDuraccion(duracion, duracion2);
    }
}

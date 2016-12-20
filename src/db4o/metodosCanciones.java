/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db4o;

import javax.swing.table.DefaultTableModel;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class metodosCanciones {
    
    public DefaultTableModel getCanciones(){
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "canciones.db4o");
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        String[] columns = {"titulo", "duracion", "cantante"};
        Query q  = bd.query();
        q.constrain(cancion.class);
        ObjectSet res = q.execute();
        int i = 0;
        Object data[][] = new String[res.size()][3];
        while (res.hasNext()) {//recorres el iterador
            cancion c = (cancion) res.next();
            data[i][0] = c.getTitulo();
            data[i][1] = c.getDuracion();
            data[i][2] = c.getCantante().getNombre();
            i++;
        }
        dtm.setDataVector(data, columns);
        bd.close();
        return dtm;
    }
    
    public void añadirCancion(String titulo, String nomCantante, String duracion) {
        
      ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");

      try{
          ObjectSet res = bd.queryByExample(new cantante(nomCantante, null));
            cantante cant = (cantante) res.next();
            cancion canc = new cancion(titulo, duracion, cant);
            bd.store(canc);
            JOptionPane.showMessageDialog(null, "Cancion añadida");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erro al añadir cancion");
            
        }
        finally{
            bd.close();
        
        }
    }
    
    public void modificarCancion(String titulo, String titulo2, String nomCantante, String duracion) {
          ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");
        try{
            ObjectSet res=bd.queryByExample(new cancion(titulo, null, null));
            cancion canc = (cancion)res.next();
            ObjectSet res2 = bd.queryByExample(new cantante(nomCantante, null));
            cantante cant = (cantante) res2.next();
            canc.setTitulo(titulo2);
            canc.setCantante(cant);
            canc.setDuracion(duracion);
            bd.store(canc);
            
            JOptionPane.showMessageDialog(null, "Cantante modificado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al modificar cantante");
        }finally{
            bd.close();
        }
    }
    
    public void eliminarCancion(String titulo) {
       ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");
       
       try{
           ObjectSet res = bd.queryByExample(new cancion(titulo, null, null));
           cancion cancion = (cancion) res.next();
           bd.delete(cancion);
           JOptionPane.showMessageDialog(null, "Cancion eliminada");
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "error al eliminar cancion");
           
       }
       finally{
           bd.close();
           
       }

        
        
    }
}

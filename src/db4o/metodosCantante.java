
package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class metodosCantante {
    
    public DefaultTableModel getCantantes() {
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        String[] columns = {"Nombre", "Estilo"};
        Query q  = bd.query();
        q.constrain(cantante.class);
        ObjectSet res = q.execute();
        int i = 0;
        Object data[][] = new String[res.size()][2];
        while (res.hasNext()) {//recorres el iterador
            cantante c = (cantante) res.next();
            data[i][0] = c.getNombre();
            data[i][1] = c.getEstilo();

            i++;
        }
        dtm.setDataVector(data, columns);
        bd.close();
        return dtm;
    }
    
    public void añadirCantante(String nombre, String estilo){
        
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");
        
        try{
            cantante cant = new cantante(nombre, estilo);            
            bd.store(cant);
            JOptionPane.showMessageDialog(null, "El cantante se ha añadido correctamente");           
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al añadir el cantante");
        }
        finally{
            bd.close();
        }
    }
    
    public void modificarCantante(String nombre, String estilo){
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");
        try{
            ObjectSet res=bd.queryByExample(new cantante(nombre, null));
            cantante c = (cantante)res.next();
            c.setEstilo(estilo);
            bd.store(c);
            
            JOptionPane.showMessageDialog(null, "Cantante modificado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al modificar cantante");
        }finally{
            bd.close();
        }
    
    }
    
    public void eliminarCantante(String nombre) {
        
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");
        
        
        try{
            ObjectSet res = bd.queryByExample(new cantante(nombre, null));
            cantante cant = (cantante) res.next();
            bd.delete(cant);
            
            JOptionPane.showMessageDialog(null,"Cantante eliminado");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar cantante");
            
        }
        finally{
            bd.close();
        }
    }
    
    
}

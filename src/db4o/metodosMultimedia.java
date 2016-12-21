
package db4o;

import javax.swing.table.DefaultTableModel;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class metodosMultimedia {
     public DefaultTableModel listarCancionesporTitulo(String nombre) {
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"canciones.db4o");
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
        String[] columns = {"Título", "Cantante", "Duracción"};
        dtm.setColumnIdentifiers(columns);
        Query q  = bd.query();
        q.constrain(cantante.class);
        q.descend("nombre").constrain(nombre);
        ObjectSet res = q.execute();
        try{ 
             cantante can =(cantante)res.next();
             System.out.println(can.getNombre());
        q  = bd.query();
        q.constrain(cancion.class);
        q.descend("cantante").constrain(can);
        ObjectSet resul = q.execute();
        while(resul.hasNext()) {
        Object[]data  = new Object[3];
        cancion c =(cancion)resul.next();
        data[0] = c.getTitulo();
        data[1] = c.getCantante().getNombre();
        data[2] = c.getDuracion();
        
        dtm.addRow(data);
         
        }
        }catch(Exception e){
            
        }
        
        bd.close();
        return dtm;
      
  }
  
  public DefaultTableModel listarCancionesporDuraccion(String duracion, String duracion2) {
    ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "canciones.db4o");
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
        
        
        String[] columns = {"Título", "Cantante", "Duracción"};
        dtm.setColumnIdentifiers(columns);
        Query q  = bd.query();
        q.constrain(cancion.class);
        Constraint constr = q.descend("duracion").constrain(duracion).smaller();
        q.descend("duracion").constrain(duracion2).greater().and(constr);
        ObjectSet res = q.execute();
        Object data[][] = new String[res.size()][3];
        int i = 0;
        while(res.hasNext()) {
        cancion c =(cancion)res.next();
        data[i][0] = c.getTitulo();
        data[i][1] = c.getCantante().getNombre();
        data[i][2] = c.getDuracion();
        i++;
         
        }
        dtm.setDataVector(data, columns);
        bd.close();
        return dtm;
    }
}

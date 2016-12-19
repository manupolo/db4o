
package db4o;

public class cantante {
    
    private String nombre;
    private String estilo;
    
    public cantante(){}
    
    public cantante(String nombre, String estilo){
        this.nombre = nombre;
        this.estilo = estilo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estilo
     */
    public String getEstilo() {
        return estilo;
    }

    /**
     * @param estilo the estilo to set
     */
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    
}

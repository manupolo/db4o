
package db4o;

public class cancion {
    
    private String titulo;
    private String duracion;
    private cantante cantante;
    
    public cancion(){}
    
    public cancion(String titulo, String duracion, cantante cant){
        this.titulo = titulo;
        this.duracion = duracion;
        this.cantante = cant;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the cantante
     */
    public cantante getCantante() {
        return cantante;
    }

    /**
     * @param cantante the cantante to set
     */
    public void setCantante(cantante cantante) {
        this.cantante = cantante;
    }
    
    
}

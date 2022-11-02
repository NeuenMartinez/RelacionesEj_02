package Entidades02;

/**
 *
 * @author NeuenMartinez
 */
public class Persona {

    private int ID;
    private String nombre;
    private Boolean muerto = false;

    public Persona() {
    }

    public Persona(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getMuerto() {
        return muerto;
    }

    public void setMuerto(Boolean muerto) {
        this.muerto = muerto;
    }

    @Override
    public String toString() {
        return "Jugador{" + ID + " "+ nombre + '}';
    }
    
    
    
}

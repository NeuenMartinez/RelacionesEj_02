package Entidades02;

import java.util.ArrayList;

/**
 *
 * @author NeuenMartinez
 */
public class Juego {

    private ArrayList<Persona>jugadores = new ArrayList<>();
    private Revolver r = new Revolver();

    public Juego() {
    }

    public Juego(ArrayList<Persona> jugadores, Revolver r) {
        this.jugadores = jugadores;
        this.r = r;
    }

    public ArrayList<Persona> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    public Revolver getR() {
        return r;
    }

    public void setR(Revolver r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugadores=" + jugadores + ", r=" + r + '}';
    }
    
    
}

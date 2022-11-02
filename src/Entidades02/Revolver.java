package Entidades02;

/**
 *
 * @author NeuenMartinez
 */
public class Revolver {

    private Integer posicionActual;
    private Integer posicionBala;

    public Revolver() {
    }

    public Revolver(Integer posicionActual, Integer posicionBala) {
        this.posicionActual = posicionActual;
        this.posicionBala = posicionBala;
    }

    public Integer getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Integer posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Integer getPosicionBala() {
        return posicionBala;
    }

    public void setPosicionBala(Integer posicionBala) {
        this.posicionBala = posicionBala;
    }

    @Override
    public String toString() {
        return "Revolver{" + "posicionActual=" + posicionActual + ", posicionBala=" + posicionBala + '}';
    }
    
    
}

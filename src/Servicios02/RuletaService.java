package Servicios02;

import Entidades02.Juego;
import Entidades02.Persona;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author NeuenMartinez
 */
public class RuletaService {

    Juego Ruleta = new Juego();
    Scanner leer = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    int aux2;

    public void crearJugador() {
        System.out.println("REGISTRO DE JUGADORES (MAX 6)");
        System.out.println("INGRESAR EL NUMERO DE JUGADORES:");
        int numjug = leer.nextInt();
        if (numjug > 6) {
            numjug = 6;
        } else if (numjug < 1) {
            numjug = 1;
        }
        for (int i = 0; i < numjug; i++) {
            System.out.println("Nombre: ");
            String nombre = leer.next();
            Ruleta.getJugadores().add(new Persona((i + 1), nombre));
        }
    }

    public void llenarRevolver() {

        Ruleta.getR().setPosicionActual(ThreadLocalRandom.current().nextInt(1, 6 + 1));
        Ruleta.getR().setPosicionBala(ThreadLocalRandom.current().nextInt(1, 6 + 1));

    }

    public boolean mojar() {

        return Ruleta.getR().getPosicionActual() == Ruleta.getR().getPosicionBala();

    }

    public void siguienteChorro() {
        Ruleta.getR().setPosicionActual(Ruleta.getR().getPosicionActual() + 1);
        if (Ruleta.getR().getPosicionActual() == 7) {
            Ruleta.getR().setPosicionActual(1);
        }
    }

    public void Disparo(Persona aux) {
        System.out.println("El jugador jala el gatillo...");
        mojar();
        if (mojar() == true) {
            System.out.println("¡PUM!");
            aux.setMuerto(true);
            System.out.println("El jugador " + aux + "cae muerto sobre la mesa...");
            llenarRevolver();
        } else {
            System.out.println("CLICK...");
            System.out.println("El jugador " + aux + "suspira... sobrevivio la ronda");
        }
        siguienteChorro();
    }

    public void girarTambor(Persona aux) {
        System.out.println("El jugador gira el tambor...");
        System.out.println("TAC.TAC.TAC.TAC.TAC.TAC.TAC.TAC.TAC");
        Disparo(aux);
    }

    public void ronda() {
        System.out.println("Comienza el juego...");
        System.out.println("-----------------------");
        System.out.println("Los jugadores seran: ");
        System.out.println("-----------------------");
        for (Persona aux : Ruleta.getJugadores()) {
            System.out.println(aux);
        }

        do {
            for (Persona aux : Ruleta.getJugadores()) {
                System.out.println("Es el turno del jugador numero " + aux.getID());
                System.out.println("El " + aux + " toma el arma");
                System.out.println(aux + " ¿Que accion desea realizar?");
                System.out.println("1. Disparar");
                System.out.println("2. Girar el tambor y luego disparar");
                int elec = leer.nextInt();
                switch (elec) {
                    case 1:
                        Disparo(aux);
                        break;
                    case 2:
                        girarTambor(aux);
                        break;
                    default:
                        System.out.println("Eleccion incorrecta... no se puede escapar del juego...");
                        System.out.println("La persona a su derecha toma el arma y le dispara a el " + aux);
                        System.out.println(aux + " cae muerto por querer escapar del juego");
                        aux.setMuerto(true);
                        llenarRevolver();
                        aux2 = aux.getID() - 1;
                }

            }
            if (Ruleta.getJugadores().get(aux2).getMuerto() == true) {
                Ruleta.getJugadores().remove(aux2);

            }

            System.out.println("-----------------------");
            System.out.println("Jugadores vivos: ");
            System.out.println("-----------------------");
            for (Persona aux : Ruleta.getJugadores()) {
                System.out.println(aux);
            }

        } while (Ruleta.getJugadores().size() > 1);

        System.out.println("EL GANADOR ES: " + Ruleta.getJugadores().get(0));
    }

}

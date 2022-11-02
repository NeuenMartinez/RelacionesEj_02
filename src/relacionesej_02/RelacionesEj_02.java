/*
 * @author NeuenMartinez
 */
package RelacionesEj_02;

import Servicios02.RuletaService;


public class RelacionesEj_02 {

    public static void main(String[] args) {


        RuletaService rs = new RuletaService();
        rs.crearJugador();
        rs.llenarRevolver();
        rs.ronda();
        
    }

}
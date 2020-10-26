
package poker;

import java.util.ArrayList;
import java.util.Scanner;

public class Poker {
        static int ID;
        static Jugador player;
        static Scanner teclado = new Scanner (System.in);
        static ArrayList <Jugador> jugadores;
        static BarajaNaipes LaBaraja;
        static Mesa LaMesa;
    public static void main(String[] args) {
        jugadores = new ArrayList <> ();
        LaBaraja = new BarajaNaipes ();
        LaMesa = new Mesa ();
        LaBaraja.Barajar();
        GenerarJugadores();
        VisualJugadores();
        LaMesa.flop(LaBaraja);
        LaMesa.turn(LaBaraja);
        LaMesa.river(LaBaraja);
        LaMesa.verMesa();
        armarManos();
        cargarSoluciones();
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).mostrarSolucion();
        }
    }
    public static void añadirJugador (){
        player = new Jugador(ID);
        player.CogerMano(LaBaraja);
        jugadores.add(player);
        ID++;
    }
    public static void GenerarJugadores (){
        boolean flag = false;
        do {
            System.out.println("Dime el numero de jugadores (max 9)");
            int numJ = teclado.nextInt();
            if (numJ>0 && numJ<10) {
                flag= true;
                System.out.println("La mano tendrá " + numJ + " jugadores");
                for (int i = 0; i < numJ; i++) {
                    añadirJugador();
                }
            }
        } while (!flag);
    }
    public static void VisualJugadores (){
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).VerMano();
        }
    }
    public static void cargarSoluciones (){
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.print("El jugador " + jugadores.get(i).ID + " tiene: ");
            jugadores.get(i).CartasSobreLaMesa();
            System.out.println();
        }
    }
    public static void armarManos (){
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).manoPosible(LaMesa);
        }
    }

    
}


package poker;

import java.util.ArrayList;

public class LogicaBaraja {
    public static void main(String[] args) {
            
        ArrayList <Integer> m = new ArrayList <> ();
        m.add(2);
        m.add(2);
        m.add(2);
        m.add(5);
        m.add(5);
        m.add(7);
        m.add(7);
        for (int i = 0; i < m.size()-4; i++) {
            if (m.size()>5){
                m.remove(0);
            }
        }
        System.out.println(m);
        }
    }
        
    
//        public static void CartaAlta (){
//        int aux; int aux1 = 0;
//        for (int i = 0; i < jugadores.size(); i++) {
//            aux = 0;
//            for (int j = 0; j < 7; j++) {
//                if (jugadores.get(i).jugadaPosible.get(j).valor > aux) {
//                    aux = jugadores.get(i).jugadaPosible.get(j).valor;
//                    aux1 = j;
//                }
//            }
//            jugadores.get(i).miSolucion.add(jugadores.get(i).jugadaPosible.get(aux1));
        //    public static void CartaAlta (){
//        for (int i = 0; i < jugadores.size(); i++) {
//            jugadores.get(i).miSolucion.add(jugadores.get(i).jugadaPosible.get(6));
//            System.out.println("El Jugador " + jugadores.get(i).ID + " tiene carta alta, " + jugadores.get(i).miSolucion.get(0).nombre + " de " + jugadores.get(i).miSolucion.get(0).mazo);
//            //una mano de poker son 5 cartas, aqui añades una, es un apaño visual durante el desarrollo, para finiquitarlo haz un doble bucle en el que se añada
//            //a cada jugador sus 5 cartas mas altas por valor y que por un bloque de texto te muestre la carta de mayor valor (la alta)
//        }
//    }
//    public static int ParejaDblParejaTrioPoker (){
//        int aux; int aux1 = 0;
//        for (int i = 0; i < jugadores.size(); i++) {
//            aux = jugadores.get(i).jugadaPosible.get(0).valor;
//            for (int j = 1; j < jugadores.get(i).jugadaPosible.size(); j++) {
//                if(jugadores.get(i).jugadaPosible.get(j).valor==aux){
//                    jugadores.get(i).miSolucion.add(jugadores.get(i).jugadaPosible.get(j));
//                    jugadores.get(i).miSolucion.add(jugadores.get(i).jugadaPosible.get(j-1));
//                    aux1++;
//                }
//                    aux = jugadores.get(i).jugadaPosible.get(j).valor;
//            }
//        }
//        return aux1;
//    }
//    public static void CartasSobreLaMesa (){
//        for (int i = 0; i < jugadores.size(); i++) {
//            if (ParejaDblParejaTrioPoker() == 4) {
//            
//            }else if (ParejaDblParejaTrioPoker() == 3){
//
//            }else if (ParejaDblParejaTrioPoker() == 2){
//
//            }else if (ParejaDblParejaTrioPoker() == 1){
//
//            }else{
//                CartaAlta();
//            }
//        }
//    }


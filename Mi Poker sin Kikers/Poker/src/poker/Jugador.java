package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class Jugador {   
    //miMano= Cartas preflop jugadaPosible=todas las cartas miSolucion = jugada (los kikers se añaden posteriormente)
    int ID;
    ArrayList <Carta> miMano;
    ArrayList <Carta> miSolucion; 
    ArrayList <Carta> jugadaPosible;
    
    public Jugador (int id){
        miMano = new ArrayList <> ();
        miSolucion = new ArrayList <> ();
        jugadaPosible = new ArrayList <> ();
        this.ID = id;
    }
    public void CogerMano (BarajaNaipes miBaraja){
        miMano.add(sacarCarta (miBaraja));
        miMano.add(sacarCarta (miBaraja));
    }
    private Carta sacarCarta (BarajaNaipes miBaraja){
        Carta miCarta;
        miBaraja.Baraja.remove(miBaraja.Baraja.size()-1);
        miCarta = miBaraja.Baraja.get(miBaraja.Baraja.size()-1);
        miBaraja.Baraja.remove(miBaraja.Baraja.size()-1);
        return miCarta;
    }
    public void VerMano (){
        System.out.println("-----");
        System.out.println("El jugador " + ID + " tiene ");
        System.out.println(miMano.get(0).nombre + " de " + miMano.get(0).mazo);
        System.out.println(miMano.get(1).nombre + " de " + miMano.get(1).mazo);
        System.out.println("-----");
    }
    public void mostrarSolucion (){
        //Elimino duplicados con la linea inferior
        miSolucion = (ArrayList<Carta>) miSolucion.stream().distinct().collect(Collectors.toList());
        System.out.println("El Jugador " + ID + " tiene:");
        for (int i = 0; i < miSolucion.size(); i++) {
            System.out.println(miSolucion.get(i).nombre + " de " + miSolucion.get(i).mazo);
        }
    }
    public void manoPosible (Mesa miMesa){
        jugadaPosible = miMano;
        for (int i = 0; i < miMesa.CartasMesa.size(); i++) {
            jugadaPosible.add(miMesa.CartasMesa.get(i));
        }
        Collections.sort(jugadaPosible, (Carta o1, Carta o2) -> o1.getValor().compareTo(o2.getValor()));
    }
    public boolean EscaleraColor (){
        if(Escalera()){
            String [] palos = {"Picas","Corazones","Tréboles","Diamantes"};
            int aux = 0;
            String check;
            for (int i = 0; i < 4; i++) {
                check = palos[i];
                if(aux < 5){
                    for (int j = 6; j >= 0; j--) {
                         if(check.equals(miSolucion.get(j).mazo)) aux++;
                    }
                    if(aux!=5) aux = 0;
                }
            }
        return aux==5;
        }
        else return false;
    }
    public boolean Color (){
        String [] palos = {"Picas","Corazones","Tréboles","Diamantes"};
        int aux = 0;
        String check;
        for (int i = 0; i < 4; i++) {
            check = palos[i];
            if(aux < 5){
                for (int j = 6; j >= 0; j--) {
                     if(check.equals(jugadaPosible.get(j).mazo)){
                         miSolucion.add(jugadaPosible.get(j));
                         aux++;
                     }
                }
                if(aux!=5){
                    miSolucion.clear();
                    aux = 0;
                }
            }
        }
        Collections.sort(miSolucion, (Carta o1, Carta o2) -> o1.getValor().compareTo(o2.getValor()));
        return aux==5;
    }
    public boolean Escalera (){
        int num = 0;
        int aux;
        aux = jugadaPosible.get(6).valor;
        for (int i = 5; i >= 0; i--){
            if(num!=4){
                if (jugadaPosible.get(i).valor == aux-1){
                    miSolucion.add(jugadaPosible.get(i+1));
                    miSolucion.add(jugadaPosible.get(i));
                    num++;
                }else{
                    miSolucion.clear();
                    num = 0;
                }
            }
            aux = jugadaPosible.get(i).valor;
        }
        if(num!=4){
            miSolucion.clear();
        }else{
            //esta reordenacion es para que queden de menor a mayor y no al reves
            Collections.sort(miSolucion, (Carta o1, Carta o2) -> o1.getValor().compareTo(o2.getValor()));
            return true;
        }
        return false;
    } 
    //esta funcion hace las parejas, dobles parejas, trios, poker y full, tambien soluciona errores de identificacion
    public int CasiTodo (){
        int aux; int aux1 = 0;
        aux = jugadaPosible.get(6).valor;
        for (int j = 5; j >= 0; j--) {
            if(jugadaPosible.get(j).valor==aux){
                miSolucion.add(jugadaPosible.get(j));
                miSolucion.add(jugadaPosible.get(j+1));
                aux1++;
            }
            aux = jugadaPosible.get(j).valor;
        }
        miSolucion = (ArrayList<Carta>) miSolucion.stream().distinct().collect(Collectors.toList());
        Collections.sort(miSolucion, (Carta o1, Carta o2) -> o1.getValor().compareTo(o2.getValor()));
        //POKER
        if (miSolucion.size() >= 4){
            for (int i = 0; i < miSolucion.size(); i++){
                aux = 0;
                for (int j = 0; j < miSolucion.size(); j++) {
                    if (Objects.equals(miSolucion.get(i).valor, miSolucion.get(j).valor)) aux++;
                    if (aux == 4) return aux;
                }
            }
        }
        //ELIMINAR Triples parejas (que rompian el full)
        if(miSolucion.size() > 5 && aux1== 3 || aux1 == 4){
            for (int i = 0; i < miSolucion.size()-4; i++) {
                miSolucion.remove(0);
            }
            if(!Objects.equals(miSolucion.get(0).valor, miSolucion.get(1).valor)){
                miSolucion.remove(0);
            }
            // aux1 = 2 porque si elimino una pareja de 3, quedan 2
            aux1 = 2;
        }
        //FULL
        if(miSolucion.size() == 5){
            return 5;
        }
        //TRIO
        else if(aux1 == 2 && miSolucion.size() == 3){
            return 3;
        }else return aux1;
    }
    //Si la pareja del Full era menor que el trío, leia antes la pareja, lo soluciono invirtiendo el orden si eso ocurre
    private void prioridadFull(){
        if(miSolucion.get(0).valor < miSolucion.get(miSolucion.size()-1).valor){
            //invierto la comparacion y asi pues ordena de mayor a menor
            Collections.sort(miSolucion, (Carta o1, Carta o2) -> o2.getValor().compareTo(o1.getValor()));
        }
    }
    public void CartaAlta (){
            miSolucion.add(jugadaPosible.get(6));
            System.out.println("Carta alta, " + miSolucion.get(0).nombre + " de " + miSolucion.get(0).mazo);
    }
    //te queda el kiker, haz una funcion basada en el size solucion, si es 5 nada, y si es menos pues que sea en funcion del tamaño (un for atado a la condicion 
    //5-solucion.size y que se añada la carta más alta del array manos posibles (o las cartas)
    public void CartasSobreLaMesa (){
        if(EscaleraColor()){
            System.out.println("Escalera de color: " + miSolucion.get(0).nombre + ", " + miSolucion.get(miSolucion.size()-1).nombre + miSolucion.get(0).mazo);
        }else if (CasiTodo() == 4) {
            System.out.println("Poker de " + miSolucion.get(0).nombre);
        }else if (CasiTodo() == 5){
            prioridadFull();
            System.out.println("Full de " + miSolucion.get(0).nombre + " y " + miSolucion.get(miSolucion.size()-1).nombre);
        }else if(Color()){
            System.out.println("Color de " + miSolucion.get(0).mazo + ", carta alta " + miSolucion.get(miSolucion.size()-1).nombre);
        }else if (Escalera()){
            System.out.println("Escalera: " + miSolucion.get(0).nombre + ", " + miSolucion.get(miSolucion.size()-1).nombre);
        }else if (CasiTodo() == 3){
            System.out.println("Trío de " + miSolucion.get(0).nombre);
        }else if (CasiTodo() == 2){
            System.out.println("Doble Pareja, " + miSolucion.get(0).nombre + " y " + miSolucion.get(2).nombre);
        }else if (CasiTodo() == 1){
            System.out.println("Pareja de " + miSolucion.get(0).nombre);
        }else{
            CartaAlta();
        }
    
    }
}

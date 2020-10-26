package poker;

public class Carta{
Integer valor;
String mazo;
String nombre;
    public Carta (int val, int aux){
        String [] palos = {"Picas","Corazones","Tréboles","Diamantes"};
        String [] nombres = {"Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Jota","Dama","Rey","As"};
        this.valor = val;
        this.mazo = palos[aux];
        this.nombre = nombres[val-2];
    }    
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Integer getValor() {
        return valor;
    }
}

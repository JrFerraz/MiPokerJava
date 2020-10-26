package poker;
import java.util.ArrayList;

public final class BarajaNaipes {
    ArrayList <Carta> Baraja = new ArrayList <> ();
    Carta crt;
    public BarajaNaipes (){
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 14; j++) {
                    AñadirCarta(j,i);
            }
        }
    }
    public void AñadirCarta (int j, int z){
        crt = new Carta (j,z);
        Baraja.add(crt);
    }
    public void VerBaraja (){
        for (int i = 0; i < Baraja.size(); i++) {
            System.out.println(Baraja.get(i).nombre + " de " + Baraja.get(i).mazo);
        }
    }
    public void Barajar (){
        int mrandom;
        for (int i = 0; i < 51; i++) {
            Carta cambiador;
            mrandom =(int) (Math.random()*(51-i));
            cambiador = Baraja.get(i);
            Baraja.set(i, Baraja.get(i+mrandom));
            Baraja.set(i+mrandom, cambiador);
        }
    }
}

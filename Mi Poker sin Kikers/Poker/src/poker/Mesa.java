package poker;
import java.util.ArrayList;

public class Mesa {
    ArrayList <Carta> CartasMesa;
    public Mesa (){
        CartasMesa = new ArrayList <> ();
    }
    public void flop (BarajaNaipes miBaraja){
        CartasMesa.add(sacarCarta(miBaraja));
        CartasMesa.add(sacarCarta(miBaraja));
        CartasMesa.add(sacarCarta(miBaraja));
    }
    public void turn (BarajaNaipes miBaraja){
        CartasMesa.add(sacarCarta(miBaraja));
    }
    public void river (BarajaNaipes miBaraja){
        CartasMesa.add(sacarCarta(miBaraja));
    }
    private Carta sacarCarta (BarajaNaipes miBaraja){
        Carta miCarta;
        miBaraja.Baraja.remove(miBaraja.Baraja.size()-1);
        miCarta = miBaraja.Baraja.get(miBaraja.Baraja.size()-1);
        miBaraja.Baraja.remove(miBaraja.Baraja.size()-1);
        return miCarta;
    }
    public void verMesa (){
        for (int i = 0; i < CartasMesa.size(); i++) {
            System.out.println("-----------------------------------");
            System.out.println(CartasMesa.get(i).nombre + " de " + CartasMesa.get(i).mazo);
            System.out.println("-----------------------------------");
        }
    }
}

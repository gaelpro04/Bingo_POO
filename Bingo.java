import java.util.ArrayList;
import java.util.Scanner;

public class Bingo implements Juego {


    private Jugador jugador;
    private Tombola tombola;
    private CartaPatrones cartaPatrones;
    private Carta cartaPatronSeleccionada;

    public Bingo()
    {
        tombola = new Tombola();
        cartaPatrones = new CartaPatrones();
    }

    private Carta seleccionarPatronCarta()
    {
        ArrayList<Carta> patronesCartas = cartaPatrones.getCartaPatrones();
        Scanner sc = new Scanner(System.in);
        int indice;

        for (int i = 0; i < patronesCartas.size(); ++i) {
            Carta cartaPatron = patronesCartas.get(i);
            System.out.println("[" + i + "]==================\n");
            cartaPatron.mostrarCartaLogica();
        }

        do {
            System.out.println("Elige el patron de la carta para jugar");
             indice = sc.nextInt();

             if (indice < 0 || indice > 38) {
                 System.out.println("Debes ingresar un indice correcto");
             }

        } while (indice < 0 || indice > 38);

        return cartaPatrones.getCartaPatrones().get(indice);
    }

    private void compararCartas(Carta cartaPatron, Carta cartaJugador)
    {

    }


    @Override
    public boolean yaAcaboElJuego() {
        return false;
    }

    @Override
    public void jugar() {

    }

    @Override
    public boolean verificar() {
        return false;
    }

    @Override
    public boolean yaHayGanador() {
        return false;
    }

    @Override
    public Jugador determinarGanador() {
        return null;
    }
}

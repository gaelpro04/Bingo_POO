import java.util.ArrayList;

public class Bingo implements Juego {


    private Jugador jugador;
    private Tombola tombola;
    private CartaPatrones cartaPatrones;

    public Bingo()
    {
        tombola = new Tombola();
        cartaPatrones = new CartaPatrones();
    }

    public void despliegarMenuPatrones()
    {
        ArrayList<Carta> patronesCartas = cartaPatrones.getCartaPatrones();

        for (int i = 0; i < patronesCartas.size(); ++i) {
            Carta cartaPatron = patronesCartas.get(i);


        }
        System.out.println("Elige el patron de la carta para jugar");
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

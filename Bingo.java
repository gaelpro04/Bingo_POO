import java.util.ArrayList;
import java.util.Scanner;

public class Bingo implements Juego {


    private Jugador jugador;
    private Tombola tombola;
    private CartaPatrones cartaPatrones;
    private Carta cartaPatronSeleccionada;
    private int indicePatron;

    public Bingo()
    {
        tombola = new Tombola();
        cartaPatrones = new CartaPatrones();
    }

    /**
     * Método que despliega menú para seleccionar el patrón del bingo
     * @return
     */
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

        indicePatron = indice;

        return cartaPatrones.getCartaPatrones().get(indice);
    }

    /**
     * Método que determinar si una carta de bingo efectivamente hizo bingo
     * @param cartaPatron
     * @param cartaJugador
     * @return
     */
    private boolean bingo(Carta cartaPatron, Carta cartaJugador)
    {
        int cantidadFalsesJugador = 0;
        boolean[][] cartaPatronLogico = cartaPatron.getTablaLogica();
        boolean[][] cartaPatronLogicoJugador = cartaJugador.getTablaLogica();

        for (int i = 0;i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (!cartaPatronLogico[i][j] && !cartaPatronLogicoJugador[i][j]) {
                    ++cantidadFalsesJugador;
                }
            }
        }
        System.out.println(cartaPatron.obtenerCantidadFalses() + " | " + cantidadFalsesJugador);
        return cartaPatron.obtenerCantidadFalses() == cantidadFalsesJugador;
    }

    /**
     * Método para verificar si la bola sacada de la tombola concuerda con algún
     * valor de la carta de bingo
     * @param bola
     * @param cartaJugador
     * @return
     */
    private boolean verificarBola(int bola, Carta cartaJugador)
    {
        return cartaJugador.contieneElemento(bola);
    }

    /**
     * Método para colocar la bola a la carta
     * @param bola
     * @param cartaJugador
     * @return
     */
    private void colocarBola(int bola, Carta cartaJugador)
    {
        cartaJugador.ocuparElemento(bola);
    }

    @Override
    public void jugar()
    {
        boolean noTermino = true;
        Scanner res = new Scanner(System.in);
        int numeroBola = 0;

        System.out.println("Ingresa tu nombre");
        jugador = new Jugador(res.next());

        cartaPatronSeleccionada = seleccionarPatronCarta();
        Carta cartaJugador = jugador.getCartaJugador();

        while (noTermino) {

            System.out.println(jugador.getNombre() + "========================");
            tombola.mostrarTabla();
            tombola.historialTiradas();
            cartaJugador.mostrarCartaBingo();
            System.out.println("Bola actual: " + numeroBola);
            if (!tombola.comprobarEspacios()) {
                System.out.println("Ya no hay bolas para sacar");
                noTermino = false;
            } else {
                System.out.println("Escribe para sacar una bola");
                String respuesta = res.next().toLowerCase();

                switch (respuesta) {
                    case "si":
                        numeroBola = tombola.tirarNumero();
                        if (verificarBola(numeroBola, cartaJugador)) {
                            colocarBola(numeroBola, cartaJugador);
                            if (bingo(cartaPatronSeleccionada, cartaJugador)) {
                                System.out.println("Has ganado!!");
                                cartaJugador.mostrarCartaBingo();
                                noTermino = false;
                            }
                        } else {
                            System.out.println("La bola no se encuentra en su bingo");
                        }
                        break;
                    case "no":
                        if (tombola.comprobarEspacios()) {
                            System.out.println("Aun quedan espacios en la tombola");
                        } else {
                            noTermino = false;
                        }
                }
            }

        }
    }
}

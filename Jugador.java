public class Jugador {

    private String nombre;
    private Carta cartaJugador;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
        cartaJugador = new Carta();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carta getCartaJugador() {
        return cartaJugador;
    }

    public void setCartaJugador(Carta cartaJugador) {
        this.cartaJugador = cartaJugador;
    }
}

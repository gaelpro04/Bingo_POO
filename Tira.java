import java.util.Random;
import java.util.LinkedHashSet;

//Clase que se encarga de la tira de números de la tombola
public class Tira {

    //Atributos uno donde es para el ultimo número o simplemente el número de asginación del valor sacado
    // y otro que se encarga se meter los números ya tirados
    private int numeroTira;
    private LinkedHashSet<Integer> numerosYaTirados;

    /**
     * Constructor por preterminado que inicializa el HashSet y el numero que se tiró
     */
    public Tira()
    {
        numeroTira = 0;
        numerosYaTirados = new LinkedHashSet<>();
    }

    /**
     * Método para tirar tombola
     * @return
     */
    public int tirar()
    {
        Random rd = new Random();

        //Se comprueba el espacio primero para que no haya un ciclo infinito
        if (comprobarEspacios()) {
            //Ciclo que termina hasta que se genere un número no repetido
            do {
                numeroTira = rd.nextInt(75) + 1;
            } while (numerosYaTirados.contains(numeroTira));

            //Al ultimo finalizando el ciclo se añade el número al HashSet queriendo decir que se
            //genero un número no repetido
            numerosYaTirados.add(numeroTira);
        }

        //Ya por ultimo en el método retornamos el valor generado que puede ser el caso que regrese
        //ceor, tal sea el caso simplemente se implementará en el bingo la acción a tomar(por reglas
        // del juego finalizaría)
        return numeroTira;
    }

    /**
     * Método para comprobar si aun hay espacios
     * @return
     */
    public boolean comprobarEspacios()
    {
        return numerosYaTirados.size() < 75;
    }

    /**
     * Método para regresar el HashSet de numero sacados
     * @return
     */
    public LinkedHashSet<Integer> getNumerosYaTirados()
    {
        return numerosYaTirados;
    }


}

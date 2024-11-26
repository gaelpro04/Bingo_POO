import java.util.ArrayList;
import java.util.LinkedHashSet;

//La clase hereda a TablaTombola
public class Tombola extends TablaTombola{

    //Un atributo para el ultimo número de la tira
    private Tira numeroTira;

    /**
     * Constructor preterminado de la clase
     */
    public Tombola()
    {
        //Se utiliza super para generar el constructor de la superclase
        super();
        numeroTira = new Tira();
    }

    /**
     * Método para mostrar la tabla
     */
    @Override
    public void mostrarTabla()
    {
        super.mostrarTabla();
    }

    /**
     * Método par tirar el número y se refleje en la tabla
     */
    public int tirarNumero()
    {
        int numeroTirado = numeroTira.tirar();
        super.ocuparElemento(numeroTirado);

        //RETORNABLE PARA EL JUEGO(CARTA DE BINGO)
        return numeroTirado;
    }

    /**
     * Método para ver el historial
     */
    public void historialTiradas()
    {
        ArrayList<Integer> listaHistorial = new ArrayList<>(numeroTira.getNumerosYaTirados());

        //Se utiliza de la formula planteada para generar solamente seis números, el ultimo número se imprimirá aparte
        //como parte de la representación de una tombola online que el ultimo dato se remarca aparte como "numero actual"
        for (int i = Math.max(0, listaHistorial.size() - 6); i < listaHistorial.size(); i++) {

            if (i != listaHistorial.size() - 1) {
                System.out.print(listaHistorial.get(i) + " ");
            }

        }
        System.out.println();
    }

    /**
     * Método para saber si aun hay espacios
     * @return
     */
    public boolean comprobarEspacios()
    {
        return numeroTira.comprobarEspacios();
    }

    public LinkedHashSet<Integer> getNumeroYaTirados()
    {
        return numeroTira.getNumerosYaTirados();
    }
}

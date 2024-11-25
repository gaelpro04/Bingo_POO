import java.util.ArrayList;
import java.util.Collections;

public class TablaTombola {

    //Atributo que simula la tabla y otro que podría decirse la parte "lógica" donde
    //si en cierta posición de la tabla(elemento) es false quiere decir que ya saco ese numero
    protected int[][] tabla;
    protected boolean[][] tablaLogica;

    /**
     * Constructor preterminado de la clase que inicializa y hace todos los elementos de la matríz con
     * los valores completos de la tombola
     */
    public TablaTombola()
    {
        int contador = 1;
        tabla = new int[5][15];
        tablaLogica = new boolean[5][15];

        //Con el contador metemos todos los numeros(del 1 al 75) y hacemos todos los elementos
        //de la tablalógica true(queriendo decir que aún no se toma)
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 15; ++j) {
                tabla[i][j] = contador;
                tablaLogica[i][j] = true;
                ++contador;
            }
        }
    }

    /**
     * Método que regresa la tabla en Object
     */
    public Object[][] getTablaString()
    {
        Object[][] datos = new Object[5][15];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                datos[i][j] = tabla[i][j];
            }
        }
        return datos;
    }


    /**
     * Método para mostrar la tabla en consola
     */
    public void mostrarTabla()
    {
        String[] bingo = {"B","I","N","G","0"};

        //Son dos ciclos anidados donde se genera la carta de la tombola convencional que
        // además si ya se seleccionó un número, lo remarca con flechas, esto con ayuda de tabla
        //lógica
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 15; ++j) {

                //If para imprimir la letra de la palabra bingo
                if (j == 0) {
                    if (tablaLogica[i][j]) {
                        System.out.print(bingo[i] + " [ " + tabla[i][j] + " ]");
                    } else {
                        System.out.print(bingo[i] + " [->" + tabla[i][j] + "<-]");
                    }

                    //Else para el salto de línea
                } else if (j == 14) {
                    if (tablaLogica[i][j]) {
                        System.out.print(" [ " + tabla[i][j] + " ]\n");
                    } else {
                        System.out.print(" [->" + tabla[i][j] + "<-]\n");
                    }
                } else {
                    if (tablaLogica[i][j]) {
                        System.out.print(" [ " + tabla[i][j] + " ] ");
                    } else {
                        System.out.print(" [->" + tabla[i][j] + "<-] ");
                    }
                }

            }
        }
    }

    /**
     * Al momento que gire la tombola y saque una bola esta se presenta aquí y si está valida la ocupa
     * @param valorBola
     */
    public void ocuparElemento(int valorBola)
    {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 15; ++j) {
                if (tabla[i][j] == valorBola && tablaLogica[i][j]) {
                    tablaLogica[i][j] = false;
                }
            }
        }
    }

    /**
     * Método para restablecer la tabla
     */
    public void restablecerTabla()
    {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 15; ++j) {
                tablaLogica[i][j] = true;
            }
        }
    }
}

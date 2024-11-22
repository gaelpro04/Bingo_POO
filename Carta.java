import java.util.Random;
import java.util.HashSet;

//Clase de una carta de Bingo que se utilizará para herencia
public class Carta {

    private int[][] tabla;
    private boolean[][] tablaLogica;

    /**
     * Constructor por preterminado
     */
    public Carta()
    {
        tabla = new int[5][5];
        tablaLogica = new boolean[5][5];

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                tablaLogica[i][j] = true;
            }
        }

        generarNumerosTabla();
    }

    /**
     * Método para crear la tabla vacía(servirá para los patrones)
     * @param vacio
     */
    public Carta(boolean vacio)
    {
        if (vacio) {
           tablaLogica = new boolean[5][5];

            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    tablaLogica[i][j] = true;
                }
            }
        }
    }

    public boolean[][] getTablaLogica()
    {
        return tablaLogica;
    }

    public void mostrarCartaBingo()
    {
        System.out.println("| B | I | N | G | O |");
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (j == 4) {
                    if (tablaLogica[i][j]) {
                        System.out.print("[ " + tabla[i][j] + " ] \n");
                    } else {
                        System.out.print("[->" + tabla[i][j] + "<-] \n");
                    }
                } else {
                    if (tablaLogica[i][j]) {
                        System.out.print("[ " + tabla[i][j] + " ] ");
                    } else {
                        System.out.print("[->" + tabla[i][j] + "<-] ");
                    }

                }

            }
        }
    }

    public void mostrarCartaLogica()
    {
        System.out.println("| B | I | N | G | O |");
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (j == 4) {
                    System.out.print("[ " + tablaLogica[i][j] + " ] \n");
                } else {
                    System.out.print("[ " + tablaLogica[i][j] + " ] ");
                }

            }
        }
        System.out.println();
    }

    private void generarNumerosTabla()
    {
        Random numRd = new Random();
        HashSet<Integer> tiraUsados = new HashSet<>();
        int numero;

        for (int i = 0; i < 5; ++i) {
            tiraUsados.clear();
            for (int j = 0; j < 5; ++j) {
                if (i == 0) {
                    do {
                        numero = numRd.nextInt(15) + 1;
                    } while (tiraUsados.contains(numero));

                } else if (i == 1) {
                    do {
                        numero = numRd.nextInt(15) + 16;
                    } while (tiraUsados.contains(numero));

                } else if (i == 2) {
                    do {
                        numero = numRd.nextInt(15) + 31;
                    } while (tiraUsados.contains(numero));

                } else if (i == 3) {
                    do {
                        numero = numRd.nextInt(15) + 46;
                    } while (tiraUsados.contains(numero));

                } else {
                    do {
                        numero = numRd.nextInt(15) + 61;
                    } while (tiraUsados.contains(numero));
                }

                tiraUsados.add(numero);
                tabla[j][i] = numero;
            }
        }
    }

    /**
     * Método para ocupar un elemento de la bola sacada de la tombola
     * @param valorBola
     */
    public void ocuparElemento(int valorBola)
    {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (tablaLogica[i][j] && tabla[i][j] == valorBola) {
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
            for (int j = 0; j < 5; ++j) {
                tablaLogica[i][j] = true;
            }
        }
    }


}

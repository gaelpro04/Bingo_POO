import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.HashSet;

//Clase de una carta de Bingo que se utilizará para herencia
public class Carta {

    private int[][] tabla;
    private boolean[][] tablaLogica;
    private ImageIcon tablaImagen;
    private int indiceVacio;
    private String rutaImagen;


    /**
     * Constructor por preterminado
     */
    public Carta()
    {
        tabla = new int[5][5];
        tablaLogica = new boolean[5][5];
        tablaImagen = null;
        indiceVacio = -1;
        rutaImagen = null;

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (i == 2 && j == 2) {
                    tablaLogica[i][j] = false;
                } else {
                    tablaLogica[i][j] = true;
                }

            }
        }
        generarNumerosTabla();
    }

    /**
     * Método para crear la tabla vacía(servirá para los patrones)
     * @param vacio
     */
    public Carta(boolean vacio, String rutaImagen, int indiceVacio)
    {
        if (vacio) {
           tablaLogica = new boolean[5][5];
           tablaImagen = new ImageIcon(Objects.requireNonNull(getClass().getResource(rutaImagen)));
           this.indiceVacio = indiceVacio;
           this.rutaImagen = rutaImagen;

            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    if (i == 2 && j == 2) {
                        tablaLogica[i][j] = false;
                    } else {
                        tablaLogica[i][j] = true;
                    }

                }
            }
        }
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getIndiceVacio()
    {
        return indiceVacio;
    }

    public void setIndiceVacio(int indiceVacio)
    {
        this.indiceVacio = indiceVacio;
    }

    public ImageIcon getTablaImagen()
    {
        return tablaImagen;
    }

    public boolean[][] getTablaLogica()
    {
        return tablaLogica;
    }

    public int[][] getTablaNumerica()
    {
        return tabla;
    }

    public Object[][] getTablaString()
    {
        Object[][] datos = new Object[tabla.length][tabla[0].length];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                datos[i][j] = tabla[i][j] == 0 ? "FREE" : tabla[i][j];
            }
        }
        return datos;
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
        int numero = 0;

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
                    if (j != 2) {
                        do {
                            numero = numRd.nextInt(15) + 31;
                        } while (tiraUsados.contains(numero));
                    } else {
                        numero = 0;
                    }


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

    public boolean contieneElemento(int valorBola)
    {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (tablaLogica[i][j] && tabla[i][j] == valorBola) {
                    return true;
                }
            }
        }
        return false;
    }

    public int obtenerCantidadFalses()
    {
        int cantidadFalses = 0;
        for (int i = 0;i < 5; ++i) {
            for (int j = 0;j < 5; ++j) {
                if (!tablaLogica[i][j]) {
                    ++cantidadFalses;
                }
            }
        }

        return cantidadFalses;
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

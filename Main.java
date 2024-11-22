import java.util.Scanner;

public class Main {
    public static void ma1in(String[] args) {

        boolean noTerminar = true;
        Carta cartaTest = new Carta();
        Tombola tombola = new Tombola();
        Scanner sc = new Scanner(System.in);
        int numeroTiradoActual = -1;

        while (noTerminar) {

            tombola.mostrarTabla();
            tombola.historialTiradas();
            System.out.println("Bola actual tirada: " + numeroTiradoActual);
            if (tombola.comprobarEspacios()) {
                System.out.println("Quieres sacar bola de la tombola");
                String respuesta = sc.next();
                if (respuesta.equals("si")) {
                    numeroTiradoActual = tombola.tirarNumero();
                    cartaTest.ocuparElemento(numeroTiradoActual);
                    cartaTest.mostrarCartaBingo();
                    System.out.println();
                } else {
                    noTerminar = false;
                }

            } else {
                System.out.println("Termino la tombola!!!!");
                noTerminar = false;
            }
        }
    }
}

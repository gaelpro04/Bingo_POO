import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean noTerminar = true;
        Tombola tombola = new Tombola();
        Scanner sc = new Scanner(System.in);
        int numeroTiradoActual = -1;

        while (noTerminar) {

            tombola.mostrarTabla();
            tombola.historialTiradas();
            System.out.println("Numero actual tirado: " + numeroTiradoActual);
            System.out.println("¿Desea girar?");
            String veredicto = sc.next();
            if (veredicto.equals("si")) {
                numeroTiradoActual = tombola.tirarNumero();
                if (!tombola.comprobarEspacios()) {
                    noTerminar = false;
                    System.out.println("Ha terminado la tombola!!!");
                }
            } else if (veredicto.equals("no")) {
                noTerminar = false;
            }
        }
    }
}

import java.util.*;

public class EjercN4 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int numero = lector.nextInt();
        lector.close();

        int resultado = 1;

        for (int i = 1; i <= numero -1; i += 1) {
            resultado *= (i + 1);

        }

        System.out.println("El factorial de " + numero + " es: " + resultado);
    }
}

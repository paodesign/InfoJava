
import java.util.*;

public class EjercN3 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int numero = lector.nextInt();
        lector.close();

        for (int i = 0; i < numero; i += 1) {
            for (int j = 0; j < numero; j++) {
                int suma = j + 1;
                if (i >= j) {

                    System.out.print(suma + " ");
                }
            }
            System.out.println();
        }
    }
}
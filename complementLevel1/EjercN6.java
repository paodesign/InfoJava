import java.util.*;

public class EjercN6 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresa Primer numero: ");
        int numero1 = lector.nextInt();
        System.out.print("Ingresa Segundo numero: ");
        int numero2 = lector.nextInt();
        lector.close();

        int resultado=1;

        for (int i = 0; i < numero2; i += 1) {
            resultado *= numero1;

        }

        System.out.println(numero1 + " elevado a " + numero2 + " = " + resultado);
    }
}

import java.util.*;

public class EjercN5 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresa Primer numero: ");
        int numero1 = lector.nextInt();
        System.out.print("Ingresa Segundo numero: ");
        int numero2 = lector.nextInt();
        lector.close();

        int resultado=0;

        for (int i = 0; i < numero2; i += 1) {
            resultado += numero1;

        }

        System.out.println(numero1 + " x " + numero2 + " = " + resultado);
    }
}

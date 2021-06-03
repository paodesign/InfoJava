
import java.util.*;

public class EjercN2 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa primer numero: ");
        int primero = lector.nextInt();
        System.out.println("Ingresa segundo numero: ");
        int segundo = lector.nextInt();
        lector.close();

        System.out.println(primero + " + "  + segundo + " = " + (primero + segundo ));
        System.out.println(primero + " - "  + segundo + " = " + (primero - segundo ));
        System.out.println(primero + " * "  + segundo + " = " + (primero * segundo ));
        System.out.println(primero + " / "  + segundo + " = " + (primero / segundo ));
        System.out.println(primero + " % "  + segundo + " = " + (primero % segundo ));
    }

}
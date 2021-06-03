import java.util.*;

public class EjercN9 {
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ingrese un texto: ");
        char [] texto = lector.next().trim().toCharArray();
        System.out.println("Ingrese una letra: ");
        char letra = lector.next().toCharArray()[0];
        lector.close();
        
        int contador = 0;

        for (int i = 0; i <texto.length; i++) {
            if (texto[i] == letra ) {
                contador ++;
            }
        }
        System.out.println(contador);
    }

}


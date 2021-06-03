import java.util.*;

public class EjercN7 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresa una palabra: ");
        String palabra = lector.next();
        lector.close();

        char[] letras = palabra.toCharArray();

        for (int i = 0; i < letras.length; i++) {
            char minuscula = letras[i];
            char mayuscula = convertirAMayuscula(minuscula);

            System.out.print(mayuscula);
        }
    }

    private static char convertirAMayuscula(char letra) {
        char resultado;

        switch (letra) {
            case 'a':
                resultado = 'A';
                break;

            case 'b':
                resultado = 'B';
                break;

            case 'c':
                resultado = 'c';
                break;

            case 'd':
                resultado = 'D';
                break;

            case 'e':
                resultado = 'E';
                break;

            case 'f':
                resultado = 'F';
                break;

            case 'g':
                resultado = 'G';
                break;

            case 'h':
                resultado = 'H';
                break;

            case 'i':
                resultado = 'I';
                break;

            case 'j':
                resultado = 'J';
                break;

            case 'k':
                resultado = 'K';
                break;

            case 'l':
                resultado = 'L';
                break;

            case 'm':
                resultado = 'M';
                break;

            case 'n':
                resultado = 'N';
                break;

            case 'ñ':
                resultado = 'Ñ';
                break;

            case 'o':
                resultado = 'O';
                break;

            case 'p':
                resultado = 'P';
                break;

            case 'q':
                resultado = 'Q';
                break;

            case 'r':
                resultado = 'R';
                break;

            case 's':
                resultado = 'S';
                break;

            case 't':
                resultado = 'T';
                break;

            case 'u':
                resultado = 'U';
                break;

            case 'v':
                resultado = 'V';
                break;

            case 'w':
                resultado = 'W';
                break;

            case 'x':
                resultado = 'X';
                break;

            case 'y':
                resultado = 'Y';
                break;

            case 'z':
                resultado = 'Z';
                break;

            default:
                resultado = ' ';
                break;
        }

        return resultado;

    }
}

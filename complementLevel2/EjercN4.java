import java.util.ArrayList;
import java.util.List;

public class EjercN4 {

    public static void main(String[] args) throws Exception {
        ArrayList<String> alumnos = new ArrayList <String>();
        String [] nombres = {"Maria","Martin","Rosa","Santiago","Daniela","Leonardo","Sofia","Jose","Carlos","Blanca","Fermando","Macarena"};
        
        for(int i=0; i < nombres.length-1; i++){
            alumnos.add(i,nombres[i]);
        }
        
        List<String> curso_1 = alumnos.subList(0, 3);
        List<String> curso_2 = alumnos.subList(4, 7);
        List<String> curso_3 = alumnos.subList(8, 11);

        System.out.println(alumnos);
        System.out.println("Curso1: "+curso_1);
        System.out.println("Curso2: "+curso_2);
        System.out.println("Curso3: "+curso_3);
    }
}


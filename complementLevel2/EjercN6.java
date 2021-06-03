import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EjercN6 {

    public static void main(String[] args) throws Exception {
        HashSet<Empleado> empleados = new HashSet<Empleado>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        Empleado e1 = new Empleado();
        e1.apellido = "Sislack";
        e1.nombre = "Moe";
        e1.dni = "6541230";
        e1.horasTrabajadas = 40;
        e1.valorPorHora = 1000;

        Empleado e2 = new Empleado();
        e2.apellido = "Simpsons";
        e2.nombre = "Homero";
        e2.dni = "123456";
        e2.horasTrabajadas = 90;
        e2.valorPorHora = 2500;

        empleados.add(e1);
        empleados.add(e2);

        System.out.println("Empleados:" + empleados);

        for (Empleado temp : empleados) {
            int sueldo = temp.horasTrabajadas * temp.valorPorHora;
            map.put(temp.dni, sueldo);
        }

        System.out.println("Dni=Sueldo: " + map);
    }

}

class Empleado {
    public String nombre;
    public String apellido;
    public String dni;
    public int horasTrabajadas;
    public int valorPorHora;

    @Override
    public String toString() {
        return ( apellido +" " + nombre + " " + dni);
    }
}
import java.util.*;

public class EjercN8 {
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        Persona persona1 = new Persona();

        System.out.println("Ingrese Nombre y Apellido: ");
        String nombre = lector.next();
        persona1.SetNombre(nombre);
        
        System.out.println("Ingrese edad: ");
        int edad = lector.nextInt();
        persona1.SetEdad(edad);

        System.out.println("Ingrese su Direccion: ");
        String direccion = lector.next();
        persona1.SetDireccion(direccion);
        
        System.out.println("Ingrese su ciudad: ");
        String ciudad = lector.next();
        persona1.SetCiudad(ciudad);

        lector.close();

        System.out.println(persona1);
    }

}

class Persona {

    private String nombre;
    private int edad;
    private String direccion;
    private String ciudad;

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetEdad(int edad) {
        this.edad = edad;
    }

    public void SetDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void SetCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return this.ciudad + " - " + this.direccion + " - " + this.edad + " - " + this.nombre;
    }
}

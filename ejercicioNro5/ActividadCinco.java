import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ActividadCinco {

    public static void main(String[] args) {

        System.out.println("Ejercicio 5: Propuesto en clases.");

        List<Empleado> employeesList = new ArrayList<Empleado>();

        // Leo el archivo y agrego los empleados a la lista.

        readEmployeeList(employeesList, "empleados.txt");

        // Menu de opciones
        printMenu(5, employeesList);

    }

    public static void printMenu(int opciones, List<Empleado> listEmployees) {

        Scanner sc = new Scanner(System.in);

        int op = 0;
        do {

            System.out.println("\n\n\t***************** Menu *****************\n\n\t");
            System.out.println("1)- Buscar empleado por apellido que comience con la letra dada\n");
            System.out.println("2)- Buscar empleado por edad (el empleado más joven y el más viejo)\n");
            System.out.println("3)- Buscar empleado con saladrio más alto y el que  tiene menor salario.\n");
            System.out.println("4)- Imprimir todos los empleados en orden alfabético,ordena por nombre.\n");
            System.out.println("5)- Salir.\n");

            try {
                op = sc.nextInt();
                sc.nextLine();

            } catch (Exception e) {
                sc.nextLine();
                continue;

            }

            switch (op) {

                case 1:

                    System.out.println("Ingresar letra : ");
                    String letter = sc.nextLine();

                    List<Empleado> listemployeesByLastName = getEmployeesByLastNameLetter(letter.charAt(0), listEmployees);

                    if (listemployeesByLastName.size() == 0) {
                        System.out.println("No hay empleados cuyo apellido  empiece con la letra " + letter);
                    } else {
                        printList(listemployeesByLastName);

                    }

                    break;

                case 2:

                    Map<String, ArrayList<Empleado>> listAdultsUnderAges = getAdultsUnderAges(listEmployees);

                    if (listAdultsUnderAges.size() == 0) {
                        System.out.println("No se ha encontrado la lista de empleados.");
                    }

                    else {
                        for (Map.Entry<String, ArrayList<Empleado>> map : listAdultsUnderAges.entrySet()) {

                            System.out.println("\n\n -- " + map.getKey() + " -- \n\n ");

                            for (Empleado employee : map.getValue()) {

                                System.out.println(" { Nombre: " + employee.getName() + " , Apellido : "
                                        + employee.getLastName() + " , Edad : " + employee.calculateAge() + " }");
                            }
                        }

                    }
                    ;
                    break;

                case 3:

                    Map<String, ArrayList<Empleado>> listaMayorMenorSueldo = getMayoryMenorSueldo(listEmployees);

                    if (listaMayorMenorSueldo.size() == 0) {
                        System.out.println("No se ha encontrado la lista de empleados.");
                    }

                    else {
                        for (Map.Entry<String, ArrayList<Empleado>> map : listaMayorMenorSueldo.entrySet()) {

                            System.out.println("\n\n -- " + map.getKey() + " -- \n\n ");

                            for (Empleado employee : map.getValue()) {

                                System.out.println(" { Nombre: " + employee.getName() + " , Apellido : "
                                        + employee.getLastName() + " , Sueldo : " + employee.getSalary() + " }");
                            }
                        }

                    }
                    ;
                    break;

                case 4:

                    List<Empleado> listaEmpleadosOrdenAlf = alphabeticalList(listEmployees);

                    if (listaEmpleadosOrdenAlf.size() == 0) {
                        System.out.println("No se ha encontrado la lista de empleados.");
                    } else {
                        printList(listaEmpleadosOrdenAlf);

                    }

                    break;

                default:
                    break;
            }
        } while (op != 5);

        sc.close();
    }

    // Imprime la lista pasada por parametro

    public static void printList(List<Empleado> listemployees) {
        for (Empleado employee : listemployees) {
            System.out.println(employee.toString());
        }
    }

    // Lee la la lista de empleados del archivo y los guarda en una lista

    public static List<Empleado> readEmployeeList(List<Empleado> listEmployees, String path) {

        String currentLine;
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(path));

            while ((currentLine = reader.readLine()) != null) {

                listEmployees.add(separateAttributes(currentLine));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return listEmployees;

    }

    /*
     * 
     * Trata cada línea (String) del archivo , separa los campos y crea un objeto
     * Empleado por cada linea
     * 
     */

    public static Empleado separateAttributes(String currentLine) {

        String[] employeeData = currentLine.split(",");

        Double salary = parseSalary(employeeData[3]);

        // Creo el empleado
        LocalDate dateOfBirth = formatDate(employeeData[2], "dd-MM-yyyy");

        Empleado e = new Empleado(employeeData[0], employeeData[1], dateOfBirth, salary);

        return e;
    }

    // Formatea la fecha pasando de String a LocalDate con un formato pasado por
    // parámetro

    public static LocalDate formatDate(String date, String dateFormat) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);

        return LocalDate.parse(date, format);

    }

    // Parsea el sueldo de String a double

    public static Double parseSalary(String salary) {
        return Double.parseDouble(salary);
    }

    /****** Calculos sobre la lista *******/

    /*
     * Método que devuelve todos los empleados que comienzan con una letra dada en
     * el apellido
     */

    public static List<Empleado> getEmployeesByLastNameLetter(char letra, List<Empleado> listEmployees)

    {

        List<Empleado> filteredList = new ArrayList<Empleado>();

        for (Empleado e : listEmployees) {

            if (Character.toLowerCase(e.getLastName().charAt(0)) == Character.toLowerCase(letra)) {

                filteredList.add(e);
            }
        }

        return filteredList;
    }

    /*
     * Método que devuelve el empleado más joven y el más viejo (necesito una
     * funcion para calcular el año basado en una fecha -> Se encuentra en la clase
     * Empleado)
     */

    public static Map<String, ArrayList<Empleado>> getAdultsUnderAges(List<Empleado> listEmployees) {

        Map<String, ArrayList<Empleado>> adultUnderAge = new HashMap<String, ArrayList<Empleado>>();

        ArrayList<Empleado> adults = new ArrayList<Empleado>();
        ArrayList<Empleado> underages = new ArrayList<Empleado>();

        int auxAdult = listEmployees.get(0).calculateAge(), auxUnderAge = listEmployees.get(0).calculateAge();

        for (Empleado e : listEmployees) {
            int age = e.calculateAge();

            // Calculo franja etaria menor

            if (age < auxUnderAge) {
                auxUnderAge = age;
                underages.removeAll(underages);
                underages.add(e);
            } else if (age == auxUnderAge) {
                underages.add(e);
            }

            // Calculo franja etaria mayor
            if (age > auxAdult) {
                auxAdult = age;
                adults.removeAll(adults);
                adults.add(e);
            } else if (age == auxAdult) {
                adults.add(e);
            }

        }

        adultUnderAge.put("Mayor/es", adults);
        adultUnderAge.put("Menor/es", underages);

        return adultUnderAge;
    }

    /*
     * Metodo para obtener el empleado que más gana y el que menos gana.
     */

    public static Map<String, ArrayList<Empleado>> getMayoryMenorSueldo(List<Empleado> listEmployees) {

        Map<String, ArrayList<Empleado>> highLow = new HashMap<String, ArrayList<Empleado>>();

        ArrayList<Empleado> higthSalary = new ArrayList<Empleado>();
        ArrayList<Empleado> lowSalary = new ArrayList<Empleado>();

        double auxHighSalary = listEmployees.get(0).getSalary(), auxLowSalary = listEmployees.get(0).getSalary();

        for (Empleado e : listEmployees) {

            double salary = e.getSalary();

            // Empleados con el mayor sueldo

            if (salary > auxHighSalary) {

                auxHighSalary = salary;

                higthSalary.removeAll(higthSalary);
                higthSalary.add(e);

            } else if (salary == auxHighSalary) {
                higthSalary.add(e);
            }

            // Empleados con el menor sueldo

            if (salary < auxLowSalary) {

                auxLowSalary = salary;

                lowSalary.removeAll(lowSalary);
                lowSalary.add(e);

            } else if (salary == auxLowSalary) {
                lowSalary.add(e);
            }

        }

        highLow.put("Mayor/es sueldos", higthSalary);
        highLow.put("Menor/es sueldos", lowSalary);

        return highLow;

    }

    /*
     * (Opcional): Imprimir todos los empleados en orden alfabético (por nombre y
     * por apellido).
     */

    public static List<Empleado> alphabeticalList(List<Empleado> listEmployees) {
        /// Orden alfabetico
        List<Empleado> alphabeticalOrderList = listEmployees.stream().sorted(Comparator.comparing(n -> n.toString()))
                .collect(Collectors.toList());
        return alphabeticalOrderList;
    }

}
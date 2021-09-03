import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado implements Comparable<Empleado>{
    
    private String name ; 
    private String lastName ;
    private LocalDate dateOfBirth ;
    private double salary ;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");        

    Empleado(String name , String lastName , LocalDate dateOfBirth , double salary){

        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;  
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }


    public int calculateAge(){

             /// Calcular Edad 

             LocalDate currentDate = LocalDate.now();
             int age = 0;
            
                 if (this.getDateOfBirth().getMonth().compareTo(currentDate.getMonth())<0 ) {
                     
 
                     age= currentDate.getYear() -  this.getDateOfBirth().getYear() ;
 
                 }
                 else if(this.getDateOfBirth().getMonth().compareTo(currentDate.getMonth())==0){
 
 
                     if (this.getDateOfBirth().getDayOfMonth()>currentDate.getDayOfMonth()) {
                         age= currentDate.getYear() -  this.getDateOfBirth().getYear() -1 ;
                     }
                     else{
                         age= currentDate.getYear() -  this.getDateOfBirth().getYear() ;
                     }
 
                 }else{
                     age= currentDate.getYear() -  this.getDateOfBirth().getYear() -1 ;
                 }
                 
                 return age;
                
    }

   
    @Override
    public int compareTo(Empleado employee) {
        if (this.name.compareTo(employee.getName())>0) {
            return 1;

        }
        return -1;
    }

    @Override
    public String toString() {
        return "{ Nombre :  "+ this.name + " | Apellido :  "+ this.lastName + " | Fecha de Nacimiento : "+ this.dateOfBirth.format(this.formatter) + " | Sueldo "+ this.salary+ " | Edad : "+ this.calculateAge()+ " }" ;
    }
}

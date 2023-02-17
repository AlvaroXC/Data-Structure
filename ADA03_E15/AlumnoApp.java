
import java.util.PriorityQueue;

public class AlumnoApp {         

    public static void main(String[] args) {
        
        PriorityQueue<AlumnoPromedio> cola = new PriorityQueue<AlumnoPromedio>();

        Alumno alumno1 = new Alumno("1", "Alvaro", "Xool");
        alumno1.addMateria(new Materias("1", "Alvaro", "Xool", "Diseño de software", 100));
        alumno1.addMateria(new Materias("1", "Alvaro", "Xool", "Estructura de datos", 100));
        alumno1.addMateria(new Materias("1", "Alvaro", "Xool", "Probabilidad", 100));
        alumno1.addMateria(new Materias("1", "Alvaro", "Xool", "Diseño web", 95));

        Alumno alumno2 = new Alumno("2", "Andrea", "Perez");
        alumno2.addMateria(new Materias("2", "Maria", "Perez", "Estructura de datos", 80));
        alumno2.addMateria(new Materias("2", "Maria", "Perez", "Probabilidad", 95));
        alumno2.addMateria(new Materias("2", "Maria", "Perez", "Base de datos", 95));
        alumno2.addMateria(new Materias("2", "Maria", "Perez", "Calculo Integral", 95));
        
        Alumno alumno3 = new Alumno("3", "Maria Jose", "Uicab Gonzalez");
        alumno3.addMateria(new Materias("3", "Maria Jose", "Uicab Gonzalez", "Diseño de software", 96));
        alumno3.addMateria(new Materias("3", "Maria Jose", "Uicab Gonzalez", "Diseño de base de datos", 96));
        alumno3.addMateria(new Materias("3", "Maria Jose", "Uicab Gonzalez", "Orientado a objetos", 90));
        alumno3.addMateria(new Materias("3", "Maria Jose", "Uicab Gonzalez", "Algortimia", 85));
        alumno3.addMateria(new Materias("3", "Maria Jose", "Uicab Gonzalez", "Probabilidad", 99));
        alumno3.addMateria(new Materias("3", "Maria Jose", "Uicab Gonzalez", "Cultura Maya", 100));
        
        cola.add(new AlumnoPromedio(alumno1));
        cola.add(new AlumnoPromedio(alumno2));
        cola.add(new AlumnoPromedio(alumno3));

        while(!cola.isEmpty()){
            AlumnoPromedio alumnoConPromedio = cola.poll();
            System.out.println("Matricula: "+alumnoConPromedio.getAlumno().getMatricula()+" Nombres: "+
            alumnoConPromedio.getAlumno().getNombres()+" Apellidos: "+alumnoConPromedio.getAlumno().getApellidos() + 
            " Promedio: " + alumnoConPromedio.getPromedioTotal());
        }


         
    }

    
}

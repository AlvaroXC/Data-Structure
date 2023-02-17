import java.util.ArrayList;
import java.util.List;

public class Alumno{

    private String matricula;
    private String nombres;
    private String apellidos;
    private List<Materias> materias;

    public Alumno(String matricula, String nombres, String apellidos){
        this.matricula=matricula;
        this.nombres= nombres;
        this.apellidos=apellidos;
        materias = new ArrayList<Materias>();
        
    }
    
    

    public void addMateria(Materias materia){
        this.materias.add(materia);
    }
    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public List<Materias> getMaterias() {
        return materias;
    }


    public void setMaterias(List<Materias> materias) {
        this.materias = materias;
    }


    @Override
    public String toString() {
        return "matricula=" + matricula + ", nombres=" + nombres + ", apellidos=" + apellidos;
    }


    


}

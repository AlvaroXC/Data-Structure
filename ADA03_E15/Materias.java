

public class Materias extends Alumno{
    private String nombreMateria;
    private int calificacionMateria;
    


    public Materias(String matricula, String nombres, String apellidos, String nombreMateria, int calificacionMateria) {
        super(matricula, nombres, apellidos);
        this.nombreMateria = nombreMateria;
        this.calificacionMateria = calificacionMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    public int getCalificacionMateria() {
        return calificacionMateria;
    }
    public void setCalificacionMateria(int calificacionMateria) {
        this.calificacionMateria = calificacionMateria;
    }

    public String toString(){
        return super.toString();
    }
}

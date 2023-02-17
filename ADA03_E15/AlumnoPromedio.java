public class AlumnoPromedio implements Comparable<AlumnoPromedio> {
    
    private Alumno alumno;
    private int promedioTotal;

    public AlumnoPromedio(Alumno alumno){
        this.alumno = alumno;
        this.promedioTotal = 0;
        for(Materias materia : alumno.getMaterias()){
            this.promedioTotal += materia.getCalificacionMateria();
        }
        this.promedioTotal = this.promedioTotal / alumno.getMaterias().size();
    }
    
    public Alumno getAlumno() {
        return alumno;
    }

    public int getPromedioTotal() {
        return promedioTotal;
    }

    @Override
    public int compareTo(AlumnoPromedio a) {
        return Integer.compare(a.promedioTotal, this.promedioTotal);
    }
}

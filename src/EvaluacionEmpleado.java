public class EvaluacionEmpleado {
    int mes;
    String identificacion;
    double calificacion;


    // Constructor
    public EvaluacionEmpleado(int mes, String identificacion, double calificacion) {
        this.mes = mes;
        this.identificacion = identificacion;
        this.calificacion = calificacion;
    }
    
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    

}

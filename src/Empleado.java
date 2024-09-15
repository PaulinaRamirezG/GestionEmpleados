public class Empleado {
    String identificacion;
    String nombre;
    String direccion;
    String eps;

    // Constructor
    public Empleado(String identificacion, String nombre, String direccion, String eps) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.eps = eps;
    }

    public Boolean isEmpleado (String identificacion){
        if (getIdentificacion().equals(identificacion)){
            return true;
        }
        return false;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEps() {
        return eps;
    }
    public void setEps(String eps) {
        this.eps = eps;
    }
}

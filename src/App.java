import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<Empleado> empleadosList = new ArrayList<>();
    static ArrayList<EvaluacionEmpleado> evaluacionEmpleadosList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido a la gestión de empleados!");
        opciones();
    }
    private static void opciones() {
        System.out.println("1. Crear empleado");
        System.out.println("2. Adicionar evaluación mensual");
        System.out.println("3. Bonificacion de un empleado");
        System.out.println("0. Salir");
        int opcion = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner con int

        switch (opcion) {
            case 1:
                crearEmpleado();
                break;
            case 2:
                crearEvaluacion();
                break;
            case 3:
                calcularBonificacion();
                break;
            default:
                scn.close();
                break;
        }
    }

    // Crea un empleado
    private static void crearEmpleado() {
        System.out.println("===================================");
        System.out.println("Ingresa la identificación del empleado");
        String identificacion = scn.nextLine();

        System.out.println("Ingresa el nombre del empleado");
        String nombre = scn.nextLine();

        System.out.println("Ingresa la dirección del empleado");
        String direccion = scn.nextLine();

        System.out.println("Ingresa la EPS del empleado");
        String eps = scn.nextLine();

        // Se adiciona al array de Empleados
        Empleado empleado = new Empleado(identificacion, nombre, direccion, eps); 
        empleadosList.add(empleado);
        opciones();
    }

    // Se crean las evaluaciones periódicas del empleado
    private static void crearEvaluacion() {
        System.out.println("===================================");
        System.out.println("Ingrese el mes de la evaluación");
        int mes = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner con int

        // Se valida el mes
        if(mes < 1 || mes > 12){
            System.out.println("Ingrese un mes válido");
            crearEvaluacion();
            return;
        }

        System.out.println("Ingresa la identificación del empleado");
        String identificacion = scn.nextLine();

        String nombreEmpleado = nombreEmpleado(identificacion);
        if (nombreEmpleado.isEmpty() || nombreEmpleado == null) {
            System.out.println("El empleado no existe");
            opciones();
            return;
        }

        System.out.println("Ingresa la evaluación");
        double calificacion = scn.nextDouble();

        // Se adiciona al array de Evaluaciones
        EvaluacionEmpleado evaluacion = new EvaluacionEmpleado(mes, identificacion, calificacion);
        evaluacionEmpleadosList.add(evaluacion);

        System.out.println("Evaluación adicionada");
        System.out.println();
        opciones();
    }

    private static void calcularBonificacion() {
        System.out.println("===================================");
        System.out.println("Ingresa la identificación del empleado");
        String identificacion = scn.nextLine();

        // Si luego de buscar el empleado, no existe se informa y no continua
        String nombreEmpleado = nombreEmpleado(identificacion);
        if (nombreEmpleado.isEmpty() || nombreEmpleado == null) {
            System.out.println("El empleado no existe");
            return;
        }

        // Se buscan las evaluaciones y se obtiene el promedio
        int cantEvaluaciones = 0;
        double sumaEvaluacion = 0;
        for (EvaluacionEmpleado evaluacion : evaluacionEmpleadosList) {
            if (evaluacion.getIdentificacion().equals(identificacion)) {
                cantEvaluaciones++;
                sumaEvaluacion += evaluacion.getCalificacion();
            }
        }

        // Si no hay evaluaciones, se informa
        if (cantEvaluaciones == 0) {
            System.out
                    .println("El empleado " + nombreEmpleado + " no tiene evaluaciones, no se puede calcular la bonificación");
            return;
        }

        // Se obtiene el promedio de las evaluaciones
        double promEvaluacion = sumaEvaluacion / cantEvaluaciones;
        Bonificacion bonificacion = new Bonificacion();
        double porcentajeBonificacion = bonificacion.calcularBonificacion(promEvaluacion);
        System.out.println("El empleado " + nombreEmpleado + " tiene un promedio de evaluacion de " + promEvaluacion
                + ", por lo tanto, su bonificación es de " + porcentajeBonificacion + "%");

    }

    // Busca la identificacion en la lista de empleados y devuelve el nombre
    private static String nombreEmpleado(String identificacion) {
        // Se valida si el empleado existe
        String nombre = "";
        for (Empleado empleado : empleadosList) {
            if (empleado.isEmpleado(identificacion)) {
                nombre = empleado.getNombre();
            }
        }

        return nombre;
    }
}

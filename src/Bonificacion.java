public class Bonificacion {
    final double BONIFICACION_ENTRE_0_199 = 0;
    final double BONIFICACION_ENTRE_2_299 = 0.5;
    final double BONIFICACION_ENTRE_3_399 = 1;
    final double BONIFICACION_ENTRE_4_5 = 1.25;

    // constructor
    public Bonificacion() {
    }

    public double calcularBonificacion (double promEvaluacion){
        if (promEvaluacion >= 0 && promEvaluacion <= 1.99){
            return BONIFICACION_ENTRE_0_199;
        }else if (promEvaluacion >= 2 && promEvaluacion <= 2.99){
            return BONIFICACION_ENTRE_2_299;
        }else if (promEvaluacion >= 2 && promEvaluacion <= 2.99){
            return BONIFICACION_ENTRE_3_399;
        }
        return BONIFICACION_ENTRE_4_5;
    }

}

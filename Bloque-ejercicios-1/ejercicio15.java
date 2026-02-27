import java.util.Scanner;

public class ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double suma =0;
        int repro = 0;
        int aprob = 0;
        System.out.println("¿Cuantos estudiantes son?: ");
        int estu = sc.nextInt();
        double[] calf = new double[estu];
        System.out.println("Ingresa la califcación del estudiantes 0: ");
            calf[0] = sc.nextDouble();
            suma = suma + calf[0];
            if (calf[0] >= 70) {
                aprob = aprob + 1;
            } else {
                repro = repro + 1;
            }
            double min = calf[0];
            double max = calf[0];
        for (int i = 1; i<calf.length; i++) {
            System.out.println("Ingresa la califcación del estudiantes " + i + ": ");
            calf[i] = sc.nextDouble();
            suma = suma + calf[i];
            if (calf[i] >= 70) {
                aprob = aprob + 1;
            } else {
                repro = repro + 1;
            }
            if (calf[i] < min ) {
                min = calf[i];
            }
            if (calf[i] > max) {
                max = calf[i];
            }
        }
        double prom = suma/calf.length;
        System.out.println("Promedio: " + prom);
        System.out.println("Máxima: " + max);
        System.out.println("Mínima: " + min);
        System.out.println("Aprobados: " + aprob);
        System.out.println("Reprobados: " + repro);
    }
}

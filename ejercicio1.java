import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números quiere ingresar?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        for (int i = 0; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
        }
        int suma = 0;
        for (int i = 0; i<numeros.length; i++) {
            suma = suma + numeros[i];
        }
        double prom = (double) suma / numeros.length;
        System.out.println("El resultado de la suma: " + suma + "\nEl promedio es: " + prom);
    }
}

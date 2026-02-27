import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números son?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        System.out.println("Ingresa el número: ");
        numeros[0] = sc.nextInt();
        int max = numeros[0];
        int min = numeros[0];
        for (int i = 1; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
            if (numeros[i] > max ) {
                max = numeros[i];
            } 
            if (numeros[i] < min) {
                min = numeros[i];
            }
        }
        System.out.println("Maximo: " + max + " en indices: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == max) {
                System.out.println(i + " ");
            }
        }
        System.out.println("Minimo: " + min + " en indices: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == min) {
                System.out.println(i + " ");
            }
        }
    }
}
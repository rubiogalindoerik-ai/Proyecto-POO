import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números son?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        int pares = 0;
        int impar = 0;
        int posv = 0;
        int negv = 0;
        int cero = 0;
        for (int i = 0; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
            if (numeros[i]%2 == 0) {
                pares = pares+1;
            } else {
                impar = impar+1;
            }
            if (numeros[i] > 0) {
                posv = posv+1;
            } else if (numeros[i] < 0) {
                negv = negv+1;
            } else if (numeros[i] == 0) {
                cero = cero+1;
            }
        }
        System.out.println("Pares: " + pares + "\nImpares: " + impar + "\nPositivos: " + posv + "\nNegativos: " + negv + "\nCeros: " + cero);

    }
}
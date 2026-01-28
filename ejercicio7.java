import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números son?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        for (int i = 0; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Arreglo invertido: ");
        for (int i = numeros.length-1; i >= 0; i--){
            System.out.println(numeros[i] + " ");
        }
    }
}

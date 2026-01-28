import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números son?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        for (int i = 0; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Ingresa el número a eliminar: ");
        int x = sc.nextInt();
        for (int i = 0; i<numeros.length; i++) {
            if (numeros[i] == x){
                numeros[i] = 0;
            }
        }
        for (int i = 0; i<numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}

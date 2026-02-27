import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números son?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        int num = 0;
        System.out.println("Ingresa el número: ");
        numeros[0] = sc.nextInt();
        boolean ordenado = true;
        for (int i = 1; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
            if (numeros[i] < numeros[i-1]) {
                ordenado = false;
                break;
            }
        }
        if (ordenado) {
            System.out.println("El arreglo esta ordenado de forma ascendente");
        } else {
            System.out.println("El arreglo NO esta ordenado de forma ascendente");
        }
    }
}

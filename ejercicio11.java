import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]  number = new int[5];
        int i = 0;
        while (i < number.length) {
            try {
                System.out.print("Ingresa valor " + i + ": ");
                number[i] = sc.nextInt();
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Error: debes ingresar un número entero");
                sc.next();
            }
        }
        System.out.println("Arreglo final: ");
        for (int n : number) {
            System.out.print(n + " ");
        }
    }
}

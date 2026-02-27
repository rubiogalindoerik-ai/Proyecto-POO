import java.util.Scanner;

public class ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iqual = 0;
        System.out.print("Ingresa el tamaño de los arreglos: ");
        int num = sc.nextInt();
        int[] arrA = new int[num];
        int[] arrB = new int[num];
        for (int i = 0; i < arrA.length; i++) {
            System.out.println("Ingresa el número para el arreglo A: ");
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < arrB.length; i++) {
            System.out.println("Ingresa el numero para el arreglo B: ");
            arrB[i] = sc.nextInt();
        }
        for (int i = 0; i < arrB.length; i++) {
            if (arrA[i] == arrB[i]) {
                iqual = iqual +1;
            }
        }
        if (iqual == arrA.length) {
            System.out.println("Los arreglos son iguales");
        } else {
            System.out.println("Los arreglos no son iguales");
        }
    }
}

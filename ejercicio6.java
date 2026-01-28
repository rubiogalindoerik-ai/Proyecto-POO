import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos números son?: ");
        int op = sc.nextInt();
        int[] numeros = new int[op];
        for (int i = 0; i<numeros.length; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Ingresa el número a buscar: ");
        int x = sc.nextInt();
        int appeer = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == x) {
                appeer = appeer+1;
            } 
        }
        if (appeer != 0) {
            System.out.println("El número " + x + " aparece " + appeer + " veces");
        } else {
            System.out.println("El número no se encontro");
        }
    }
}

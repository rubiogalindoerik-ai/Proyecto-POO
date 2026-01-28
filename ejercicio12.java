import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = null;
        boolean salir = false;
        int found = -1;
        do {
            System.out.println("1.Llenar un arreglo de n enteros.");
            System.out.println("2.Mostrar el arreglo.");
            System.out.println("3.Mostrar el máximo y el mínimo.");
            System.out.println("4.Buscar un valor de x en el arreglo.");
            System.out.println("5.Salir.");
            System.out.println("Ingresa tu número de opcion: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("De cuantos números quieres el arreglo: ");
                    int num = sc.nextInt();
                    numbers = new int[num];
                    for (int i = 0; i < numbers.length; i++ ) {
                        System.out.println("Ingresa el número " + i + ": ");
                        numbers[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    if (numbers == null || numbers.length == 0) {
                        System.out.println("Arreglo vacio");
                    } else {
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.print(numbers[i] + " ");
                        }
                    }
                    break;
                case 3:
                    if (numbers == null || numbers.length == 0) {
                        System.out.println("Arreglo vacio");
                    } else {
                        int max = numbers[0];
                        int min = numbers[0];
                        for (int i = 0; i<numbers.length; i++) {
                            if (numbers[i] > max) max = numbers[i];
                            if (numbers[i] < min) min = numbers[i];
                        }
                        System.out.println("Maximo: " + max);
                        System.out.println("Minimo: " + min);
                    }
                    break;
                case 4:
                    if (numbers == null || numbers.length == 0) {
                        System.out.println("Arreglo vacio");
                    } else {
                        System.out.println("¿Que numero quieres buscar?: ");
                        int bucs = sc.nextInt();
                        for (int j = 0; j<numbers.length; j++) {
                            if (numbers[j] == bucs) {
                                found = j;
                            } 
                        }
                        if (found != -1) {
                            System.out.println("El numero se encuentra en la posicion: " + found);
                        } else {
                            System.out.println("El numero no se encuntra en el arreglo");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    salir = true;
            }
        } while (!salir);
    }
}

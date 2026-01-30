import java.util.Scanner;

public class avanproyect {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n----- SISTEMA DE GESTIÓN DE BIBLIOTECA -----");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Consultar libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

}  


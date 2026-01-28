import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el número de filas: ");
        int fil = sc.nextInt();
        System.out.println("Ingresa el número de columnas: ");
        int col = sc.nextInt();
        int[][] suma = new int[fil][col]; 
        for (int i = 0; i < fil; i++) {
            System.out.println("Fila " + i + ":");
            for (int j = 0; j < col; j++) {
                suma[i][j] = sc.nextInt(); 
            }
        }
        for (int i = 0; i< fil; i++) {
            int sumaFila = 0;
            for (int j = 0; j< col; j++) {
                sumaFila += suma[i][j];
            }
            System.out.println("Suma fila " + i + ":" + sumaFila);
        }
        for (int j = 0; j< col; j++) {
            int sumaColum = 0;
            for (int i = 0; i< fil; i++) {
                sumaColum += suma[i][j];
            }
            System.out.println("Suma columna " + j + ":" + sumaColum);
        }
    }
}

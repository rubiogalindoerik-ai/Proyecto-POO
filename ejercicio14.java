import java.util.Scanner;

public class ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vocales = 0;
        int consonantes = 0;
        System.out.println("Ingresa la palabra: ");
        String palabra = sc.nextLine();
        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i ++) {
            char c = Character.toLowerCase(letras[i]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
                vocales++;
            } else {
                consonantes++;
            }
        }
        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
    }
}

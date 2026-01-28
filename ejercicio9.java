public class ejercicio9 {
    public static void main(String[] args) {
        int[] A = {1, 4, 7};
        int[] B = {2, 3, 6, 8};
        int[] C = new int[A.length + B.length];
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            C[k] = A[i];
            k++;
        }
        for (int i = 0; i < B.length; i++) {
            C[k] = B[i];
            k++;
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length-1; j++) {
                if (C[j] > C[j + 1]) {
                    int temp = C[j];
                    C[j] = C[j+1];
                    C[j+1] = temp;
                }
            }
        }
        System.out.println("Arreglos combinados y ordenados: ");
        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + " ");
        }
    }
}

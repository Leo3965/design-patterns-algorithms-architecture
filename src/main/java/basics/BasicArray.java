package basics;

import java.util.Arrays;
import java.util.Comparator;

public class BasicArray {
    public static void main(String[] args) {
        removingElements();
    }

    private static void declarationAndInitialization() {
        // declaração instanciação
        int[] notas = new int[5];

        //inicialização
        int[] notas2 = new int[]{8, 5, 4, 9, 10};
        int[] notas3 = {1, 2, 3, 4, 5};
    }

    private static void printing() {
        System.out.println(Arrays.toString(new int[]{1, 2, 3}));
    }

    private static void reverting() {
        Integer[] numbers = {1 ,2 ,3, 4};
        Arrays.sort(numbers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(numbers));
    }

    private static void removingElements() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] newArr = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, newArr, 0, 2);
        System.arraycopy(numbers, 3, newArr, 2, 2);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(newArr));
    }
}

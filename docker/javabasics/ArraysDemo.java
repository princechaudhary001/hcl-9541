package javabasics;

import java.util.Arrays;

/** Module 1: 1D / 2D / jagged arrays and the java.util.Arrays utility class. */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};
        int[] zeros = new int[3];    // default 0
        System.out.println("length = " + arr.length + ", zeros = " + Arrays.toString(zeros));

        int max = arr[0], min = arr[0];
        for (int v : arr) { max = Math.max(max, v); min = Math.min(min, v); }
        System.out.println("max = " + max + ", min = " + min);

        Arrays.sort(arr);
        System.out.println("sorted = " + Arrays.toString(arr));
        System.out.println("binarySearch(7) = " + Arrays.binarySearch(arr, 7));   // array must be sorted

        int[] copy = Arrays.copyOf(arr, 7);          // padded with 0
        int[] part = Arrays.copyOfRange(arr, 1, 4);
        System.out.println("copy = " + Arrays.toString(copy) + ", range = " + Arrays.toString(part));
        System.out.println("equals = " + Arrays.equals(arr, arr.clone()));

        // Reverse in place
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
        System.out.println("reversed = " + Arrays.toString(arr));

        // 2D array
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
        System.out.println(Arrays.deepToString(matrix));

        // Transpose
        int[][] t = new int[3][2];
        for (int i = 0; i < 2; i++) for (int j = 0; j < 3; j++) t[j][i] = matrix[i][j];
        System.out.println("transpose = " + Arrays.deepToString(t));

        // Jagged array
        int[][] jagged = new int[3][];
        for (int i = 0; i < 3; i++) {
            jagged[i] = new int[i + 1];
            Arrays.fill(jagged[i], i + 1);
        }
        System.out.println("jagged = " + Arrays.deepToString(jagged));

        // Out-of-bounds is a runtime exception
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}

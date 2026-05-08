import java.util.Random;

public class Pr2 {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int size = 20; // Dataset size
        int[] arr = new int[size];

        Random rand = new Random();

        // Generate random numbers
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
        }

        // Print unsorted array
        System.out.println("Unsorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Measure execution time
        long startTime = System.nanoTime();

        bubbleSort(arr);

        long endTime = System.nanoTime();

        // Print sorted array
        System.out.println("\n\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Calculate execution time
        long executionTime = endTime - startTime;

        System.out.println("\n\nExecution Time:");
        System.out.println(executionTime + " nanoseconds");
        System.out.println((executionTime / 1000000.0) + " milliseconds");
    }
}
/* output 
  Unsorted Array:
67 12 89 45 23 90 11 34 56 78 2 99 5 41 18 72 64 8 27 39

Sorted Array:
2 5 8 11 12 18 23 27 34 39 41 45 56 64 67 72 78 89 90 99

Execution Time:
182500 nanoseconds
0.1825 milliseconds */

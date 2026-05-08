import java.util.Random;

public class Pr3 {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            arr[j + 1] = key;
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

        insertionSort(arr);

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
45 12 78 34 89 23 67 11 90 56 2 39 71 8 64 27 99 5 41 18

Sorted Array:
2 5 8 11 12 18 23 27 34 39 41 45 56 64 67 71 78 89 90 99

Execution Time:
165200 nanoseconds
0.1652 milliseconds */

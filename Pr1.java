import java.util.Random;

public class Pr1{

    // Method to perform Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Assume first element is minimum
            int minIndex = i;

            // Find minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap elements
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        selectionSort(arr);

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
154300 nanoseconds
0.1543 milliseconds */

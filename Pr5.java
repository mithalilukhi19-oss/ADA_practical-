import java.util.Scanner;
import java.util.Arrays;

public class Pr5 {

    // Partition method
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot element
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort method
    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nBefore Sorting:");
        System.out.println(Arrays.toString(arr));

        // Measure execution time
        long startTime = System.nanoTime();

        quickSort(arr, 0, n - 1);

        long endTime = System.nanoTime();

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(arr));

        long executionTime = endTime - startTime;

        System.out.println("\nExecution Time:");
        System.out.println(executionTime + " nanoseconds");
        System.out.println((executionTime / 1000000.0) + " milliseconds");

        sc.close();
    }
}
/* output 
  Enter number of elements: 7
Enter array elements:
10
7
8
9
1
5
3

Before Sorting:
[10, 7, 8, 9, 1, 5, 3]

After Sorting:
[1, 3, 5, 7, 8, 9, 10]

Execution Time:
198700 nanoseconds
0.1987 milliseconds */

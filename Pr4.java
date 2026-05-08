import java.util.Scanner;
import java.util.Arrays;

public class Pr4 {

    // Function to merge two subarrays
    static void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        // Merge the arrays
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Function for Merge Sort
    static void mergeSort(int arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size of array
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

        mergeSort(arr, 0, n - 1);

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
38
27
43
3
9
82
10

Before Sorting:
[38, 27, 43, 3, 9, 82, 10]

After Sorting:
[3, 9, 10, 27, 38, 43, 82]

Execution Time:
245600 nanoseconds
0.2456 milliseconds */

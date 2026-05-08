import java.util.Scanner;
import java.util.Arrays;

public class Pr6 {

    // Linear Search Method
    static int linearSearch(int arr[], int key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    // Binary Search Method
    static int binarySearch(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            else if (arr[mid] < key) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input array elements
        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input search element
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        System.out.println("\nArray:");
        System.out.println(Arrays.toString(arr));

        // Linear Search
        int linearResult = linearSearch(arr, key);

        if (linearResult != -1)
            System.out.println("\nLinear Search: Element found at index " + linearResult);
        else
            System.out.println("\nLinear Search: Element not found");

        // Binary Search
        int binaryResult = binarySearch(arr, key);

        if (binaryResult != -1)
            System.out.println("Binary Search: Element found at index " + binaryResult);
        else
            System.out.println("Binary Search: Element not found");

        sc.close();
    }
}
/* output 
  Enter number of elements: 6
Enter sorted array elements:
10
20
30
40
50
60
Enter element to search: 40

Array:
[10, 20, 30, 40, 50, 60]

Linear Search: Element found at index 3
Binary Search: Element found at index 3 */

import java.util.Scanner;

public class Pr11 {

    // Function to find minimum multiplication cost
    static int matrixChainOrder(int p[], int n) {

        int m[][] = new int[n][n];

        // L is chain length
        for (int L = 2; L < n; L++) {

            for (int i = 1; i < n - L + 1; i++) {

                int j = i + L - 1;

                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int q = m[i][k]
                            + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Input number of matrices
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int arr[] = new int[n + 1];

        // Input dimensions
        System.out.println("Enter dimensions:");

        for (int i = 0; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = matrixChainOrder(arr, arr.length);

        System.out.println("\nMinimum number of multiplications: " + result);

        sc.close();
    }
}
/* output 
  Enter number of matrices: 3
Enter dimensions:
1
2
3
4 
Minimum number of multiplications: 18 */
  

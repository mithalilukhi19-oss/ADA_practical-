import java.util.Scanner;

public class Pr10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int profit[] = new int[n];
        int weight[] = new int[n];

        // Input profits
        System.out.println("Enter profits:");

        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        // Input weights
        System.out.println("Enter weights:");

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        // Input knapsack capacity
        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        // DP table
        int K[][] = new int[n + 1][W + 1];

        // Build table
        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }

                else if (weight[i - 1] <= w) {

                    K[i][w] = Math.max(
                            profit[i - 1] +
                            K[i - 1][w - weight[i - 1]],
                            K[i - 1][w]);
                }

                else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        // Output result
        System.out.println("\nMaximum Profit: " + K[n][W]);

        sc.close();
    }
}
/* output 
  Enter number of items: 3

Enter profits:
60
100
120

Enter weights:
10
20
30

Enter knapsack capacity: 50
Maximum Profit: 220 */

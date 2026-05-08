import java.util.Scanner;

public class Pr9{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of coin types
        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();

        int coins[] = new int[n];

        // Input coin values
        System.out.println("Enter coin values:");

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Input amount
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        // DP array
        int dp[] = new int[amount + 1];

        // Initialize DP array
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        // Find minimum coins required
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i],
                                     dp[i - coin] + 1);
                }
            }
        }

        // Output result
        if (dp[amount] > amount)
            System.out.println("No solution possible");
        else
            System.out.println("Minimum Coins Required: " + dp[amount]);

        sc.close();
    }
}
/* output 
  Enter number of coin types: 3
Enter coin values:
1
2
5
Enter amount: 11
Minimum Coins Required: 3 */

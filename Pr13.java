import java.util.Scanner;

public class Pr13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first string
        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        // Input second string
        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        int m = X.length();
        int n = Y.length();

        // DP table
        int dp[][] = new int[m + 1][n + 1];

        // Build DP table
        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                }

                else if (j == 0) {
                    dp[i][j] = i;
                }

                // If characters match
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                // If characters do not match
                else {

                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                                            dp[i][j - 1]);
                }
            }
        }

        System.out.println("\nLength of Shortest Common Supersequence: " + dp[m][n]);

        sc.close();
    }
}
/* output 
  Enter first string: AGGTAB
Enter second string: GXTXAYB

Length of Shortest Common Supersequence: 9. */

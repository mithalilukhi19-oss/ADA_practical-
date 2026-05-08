import java.util.Scanner;

public class Pr12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first string
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        // Input second string
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        // DP table
        int dp[][] = new int[m + 1][n + 1];

        // Build DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // If characters match
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // If characters do not match
                else {

                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i][j - 1]);
                }
            }
        }

        System.out.println("\nLength of Longest Common Subsequence: " + dp[m][n]);

        sc.close();
    }
}
/* output 
  Enter first string: ABCBDAB
Enter second string: BDCAB

Length of Longest Common Subsequence: 4. */

package Hot010;

import java.util.AbstractQueue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public boolean isMatch(String s, String p) {

        s=" "+s;
        p=" "+p;

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];


        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')
                        dp[i][j] = dp[i][j - 2];
                    else {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];

                    }
                }
            }
        }
        return dp[m][n];
    }
}
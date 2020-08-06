package Leetcode322;

public class Solution {

    public int coinChange(int[] coins, int amount) {

        if(coins.length == 0) return -1;

        int[] dp = new int[amount+1];

        for(int i = 0;i<=amount;i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;



        for(int i = 1;i<=amount;i++){

            for(int j = 0 ; j <coins.length;j++){

                if( i - coins[j] < 0) continue;
                dp[i] =  Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }

        return dp[amount] == amount+1 ? dp[amount] : -1;


    }
}

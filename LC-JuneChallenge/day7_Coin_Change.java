/**
Problem - Coin Change 2
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example -

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

**/

/** The below solution is top down dynamic programming where each time we ask a question whether a coin can be included or not and 
sum up the ways if it is included + not included **/
class Solution {
    
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
		//amount 0 can be made with any coin, thus 1 possible way
        for(int i = 0; i < coins.length+1; i++){
            dp[i][0] = 1;
        }
        
		//no amount > 0 can be made without any coin, therefore 0 ways
        for(int i = 1; i <= amount; i++){
            dp[0][i] = 0;
        }
        
		
        for(int i = 1 ; i < coins.length+1 ; i++){
            for(int j = 1 ; j <= amount ; j++){
                if(coins[i-1] > j){
                    //can't use a bigger amount to form a smaller amount
                    dp[i][j] = dp[i-1][j];
                }else{
					//total ways to form an amount 'j' with coin 'i' = do not include coin 'i' (in that case same as i-1) + include i (then amount left is j-i, add the ways to form that)
					// subproblem					
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
    }
}
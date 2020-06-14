/**
Problem - Largest Divisible Subset

Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

Example - 
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
**/

/** Solution

Using dynamic programming where subproblem is 
given divisible subset [a, b, c] of size 3, if d%c == 0, that is d can be included - [a, b, c, d] -> size will be 4

therefore maintain size (dp) array to store max size posible till i.

Runtime - for each integer we are checking previous integers are divisible or not - O(n^2)
**/

class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        
        if(nums.length == 0){
            return subset;
        }
        
        //dp[i] will contain the size max divisible subset till i
        int[] dp = new int[nums.length];
        
        //the minimum size possible can be 1, just containing one integer, therefore initialise with 1
        Arrays.fill(dp, 1);
        
        //sorting is required so that the values in dp are increasing which helps in reconstructing
        //also we can use (higher index mod lower index) directly to find if they are divisible or not
        Arrays.sort(nums); 
        
        //keep track of maximum value of size, because we can reconstruct the actual subset starting that value
        int maxDPIndex = 0;
        int maxDPValue = 1;
        
        for(int i = 1 ; i < nums.length; i++){
            for(int j = i-1; j >= 0 ; j--){
                if(nums[i]%nums[j] == 0){
                    
                    //if the number is divible by smaller number, updaate the value of size
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    
                    if(dp[i] > maxDPValue){
                        maxDPValue = dp[i];
                        maxDPIndex = i;
                    }
                }
            }
        }
        
        //if max size of subset is 1, return that
        if(maxDPValue == 1){
            subset.add(nums[maxDPIndex]);
            return subset;
        }
        
        subset.add(nums[maxDPIndex]);
        
        //this is the next Value of dp we are
        int nextInt = maxDPValue - 1;
    
        //start from highest size and track the next value which is divisible and of size - 1
        for(int j = maxDPIndex - 1; j >= 0; j--){ 
            if(dp[j] == nextInt && subset.get(subset.size()-1)%nums[j]==0){
                 
                    subset.add(nums[j]);
                    nextInt--;
                 
            }
        } 
        
        return subset;
    }
}
/**
Problem - Is Subsequence

Given a string s and a string t, check if s is subsequence of t.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example -
Input: s = "abc", t = "ahbgdc"
Output: true
**/

/** Solution -
Here, I have used top down dynamic programming as there is a subproblem.
Key points :
1. no string s can be a substring of empty string "".
2. "" empty string is a substring of all strings t.
3. Subproblem -> 
if char at s[i] == chat at t[j], 
	then s till i is substring of t till j if 
	s till i-1 is a substring of t till j-1.
else 
	s till i is a substring of t till j if
	s till i-1 is a substring of t till j
	
Runtime Complexity-
O(length of s * length of t)

space - O(length of s * length of t) for dp array
**/
class Solution {
    public boolean isSubsequence(String s, String t) {
        
		//initiallising with size 1+length to include empty string
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
		//no string can be a subset of empty string
        for(int i = 0; i < s.length() + 1 ; i++){
            dp[i][0] = 0;
        }
        
		//empty string is a subset of all strings
        for(int j = 0; j < t.length() + 1; j++){
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < s.length() + 1 ; i++ ){
            for(int j = 1; j < t.length() + 1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
					//subproblem at i-1 and j-1
                    dp[i][j] = dp[i-1][j-1];
                }else{
					//subproblem at j-1 for t
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        if(dp[s.length()][t.length()] == 1){
            return true;
        }
        return false;
    }
}
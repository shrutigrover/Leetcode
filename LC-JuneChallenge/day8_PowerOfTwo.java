/**

Problem - Power of Two
Given an integer, write a function to determine if it is a power of two.

Example-

Input: 16
Output: true
Explanation: 2^4 = 16

**/

class Solution {
    public boolean isPowerOfTwo(int n) {
        
		//edge case if n <= 0
        if(n <= 0){
            return false;
        }
        
        while(n > 1){
			//if its not a power of 2, there will be a odd remainder, eg, 12/2 = 6/2 = 3(odd)
            if(n%2 != 0){
                return false;
            }
            n = n/2;
        }
        
        return true;
    }
}
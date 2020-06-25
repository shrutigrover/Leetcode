/**
Problem - Permutation Sequence

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Example - 
Input: n = 3, k = 3
Output: "213"
**/

/** Solution -

The below solution uses recursion to form all possible permutations
The optimisation is done by using a count to stop recursion on the kth count.

Runtime - O(n*n!) - for each character in string of size 'n', n! recursive calls are made

Space - O(n) Recursive call stack is called n times, when top value returns 

**/

class Solution {
    
    int count;
    String ans;
    
    private void permute(String orig, String curr){
        
        if(count <= 0){
             return;
        } 
        
        if(orig.isEmpty()){
            
            ans = curr;
            count = count - 1;
            
        }else{
                for(int i  = 0; i < orig.length(); i++){
                    permute(orig.substring(0, i) + orig.substring(i+1), curr + orig.charAt(i));
                }         
        }

    }
    
    public String getPermutation(int n, int k) {
        
        String original = "";
       
        for(int i = 1; i <= n; i++){
            original = original + i;
        }
        
        count = k;
        permute(original, "");

        return ans;
    }
}
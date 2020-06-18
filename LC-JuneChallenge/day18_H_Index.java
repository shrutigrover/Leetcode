/**
Problem - H-Index II

Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example -
Input: citations = [0,1,3,5,6]
Output: 3 
**/

/** Solution-

The below solution uses binary search to find the paper with citation ci such that number of papers with atleast ci citations are greater than ci.
Thus, ci is the h-index value. As the papers are in ascending order of citations, BS can be applied.
Runtime - O(logn)
**/
 
class Solution {
    public int hIndex(int[] citations) {
        
        int lo = 0, hi = citations.length - 1, lastInd =  citations.length - 1;
        
		//if empty array or number of citations for all papers is 0
		if(hi == -1 || citations[hi] == 0){
            return 0;
        }
		
        int mid = lo + (hi-lo)/2;
        
        while(lo < hi){
		
			//number of papers with atleast ci citations are greater than ci, there is possibility of finding higher value - go right else search left
            if(lastInd - mid + 1 > citations[mid]) lo = mid + 1;
            else hi = mid;
        
            mid = lo + (hi-lo)/2;
        }

        return lastInd-mid+1;
        
    }
}
/**

Problem - Random Pick with Weight
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Example -
Input:  ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
		[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

**/
class Solution {

	//[1, 3] at ind 0 and 1 can be expanded as [0, 1,1,1],i.e. 0 occurs 1 time and 1 occurs 3 times
	//however if we expand the array w like this and values are large then we might get MemoryOutOfBound Exception
	//essentially we just need the last ind at which each ind occurs - can be written as [0, 3] (compressed) in this case as last ind at which 0 occurs is 0 and 1 is 3
    //compressed - [0, 3]  expanded = [0, 1, 1, 1]
	private List<Integer> count_w = new ArrayList<Integer>();
    
    public Solution(int[] w) {
        int curr;
        //forming list with last ind of each weight
		count_w.add(w[0] - 1);
        
        for(int i = 1; i < w.length; i++){
            curr = count_w.size() - 1;
            count_w.add(count_w.get(curr) + w[i]);
        }
        
    }
    
    public int pickIndex() {
        
		//a random index is chosen from the expanded version of indexes(expanded by weight)
        int i = (int)(Math.random()*(count_w.get(count_w.size()-1)+1));
        
        int l = 0;
        int r = count_w.size() - 1;
        
		//binary search is used to find index where the i <= value in the compressed version
		//because this gives index value in actual expanded version
        while(l < r){
            int m = l + (r-l)/2;
            
            if(i <= count_w.get(m)){
                r = m;
            }else{
                l = m + 1;
            }
        }
        
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
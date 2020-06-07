/**
Problem - Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Example-

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
**/

/** 
The below solution is slow as the runtime complexity is O(n^3), but it got accepted in leetcode.

Alternate Solution -
1. Sort people as if height is same, sort in increasing order of k, else, sort in decreasing order of height.
2. insert the new people array's elements based on k value, i.e. the new index of the element is k.

Correctness - When we do step 1,  we make sure the elements with same height are in correct position relative to each other.
Also, as everything is arranged in dec order if height, we just need to move people in front based on number of taller people in front
which is accomplished in step 2.

Complexity -
using ArraysList add(index, element) operation - O(n^2) ( for each element in people, do add(index, element) -> O(n^2) )
**/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
	
		//sort in increasing order based on k
        Arrays.sort(people, new Comparator<int[]>(){
            
            @Override
            public int compare(final int[] entry1, final int[] entry2) { 

            if (entry1[1] == entry2[1]) 
                return 1; 
            else
                return -1; 
          } 
        });
        
        //place the element based on k in correct position
        for(int i = 0; i < people.length; i++){
            int count = 0;
            int comp = people[i][1];
            
            for(int j = 0; j < i; j++){
                if(people[j][0] >= people[i][0]){
                    count++;
                }
                if(count > comp){
                    int[] temp = people[i];
                    while(i > j){
                        people[i] = people[i-1]; 
                        i--;
                    }
                    people[i] = temp;
                    break;
                }
            }
        }
        
        return people;
    }
}
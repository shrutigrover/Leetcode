/**
Problem - Sort Colors

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example -
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
**/

/**
Solution -

We will use 3 pointers to partition the array such that

0 to low - 1 -> 0
low to mid - 1 -> 1
mid to high - 1 -> minimimise, these are unsorted numbers
high to N -> 2

Runtime Complexity - As single pass of the array elements is required, worst case complexity is  O(n)

Space COmplexity - O(1) - in-place sorting
**/

class Solution {
    public void sortColors(int[] nums) {
        
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while(mid <= high){
            if(nums[mid] == 0){
                //swap mid and low
                nums[mid] = nums[low];
                nums[low] = 0;
                
                //maintaining 0 to (low - 1) as 0 and low to (mid - 1) as 1
                low++;
                mid++;
                
            }else if(nums[mid] == 1){
                
                //maintaing low to (mid-1) as 1
                mid++;
                
            }else{
                //swap mid and high
                nums[mid] = nums[high];
                nums[high] = 2;
                
                //maintaining mid to (high - 1) as 1 and high to N as 2
                high--;
            }
        }
     }
}
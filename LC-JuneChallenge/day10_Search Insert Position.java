/**
Problem - Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Example - 

Input: [1,3,5,6], 5
Output: 2

Input: [1,3,5,6], 2
Output: 1
**/

/**
Solution -
As the array is sorted, we can exploit Binary Search Algorithm to find the correct position of the target.

Runtime Complexity - O(log base2 n) - depth of the binary search tree - everytime we are just searching in the half of the array
between low and high - so by the time we have found the target, that will be the last node ( height of the BST)
**/

class Solution {
    public int searchInsert(int[] nums, int target) {
	
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] >= target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}
/**
Problem - Two City Scheduling

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Example-
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
**/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
		//store sum of ticket price if all employees travel to A = A1 + A2 + A3 + A4
        int sum = 0;
        
		//store the difference of prices of city B - city A = (B1 - A1) + (B2 - A2) + (B3 - A3) + (B4 - A4)
        int[] diff = new int[costs.length];
		
        for(int i = 0; i < costs.length; i++){
            sum = sum + costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }
        
		//To decide what travels from B should be chosen instead of A, we will sort differences in ascending order to get N initial values
        Arrays.sort(diff);
		
		// A1 + A2 + A3 + A4 + (Bi -Ai) where i is initial N values - this lets us chose minimum B values/ min price to B = final min price
        for(int i = 0; i < costs.length/2; i++){
            sum = sum + diff[i];
        }
        return sum;
    }
}
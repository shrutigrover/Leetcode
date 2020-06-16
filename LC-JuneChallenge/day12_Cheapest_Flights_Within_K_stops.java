/**
Problem - Cheapest Flights Within K Stops

There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example -
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200

**/

/** The below solution is calculating the distance and weight from source node to all nodes. Finally, the smallest dist to the destination
with atmost K nodes is taken.

The solution below is not optimal as unnesarry amount of work is done to calculating all distances. 
Rather, a min heap can be used keeping track of K, s.t whenever destination is encountered, return the distance.
because in min heap, everytime the node with smallest dist is retrieved, it ensures that we get the min dist when dest is reached
**/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        if(flights.length == 0){
            return -1;
        }
        
        if(n == 1){
            if(src == dst){
                return 0;
            }else{
                return -1;
            }
        }
        
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<ArrayList<ArrayList<Integer>>>(n);
        
        ArrayList<ArrayList<Integer>> dist = new ArrayList<ArrayList<Integer>>(n);
        
        ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>(n);
        
        Set<Integer> visited = new HashSet<Integer>();
        
        Queue<Integer> q = new LinkedList<>(); 
        
        q.add(src);
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<ArrayList<Integer>>());
            dist.add(new ArrayList<Integer>());
            count.add(new ArrayList<Integer>());
            if(i == src){
                dist.get(i).add(0);
                count.get(i).add(-1);
            }
            
        }
        
        for(int i = 0; i < flights.length; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(flights[i][1]);
            curr.add(flights[i][2]);
            
            adjList.get(flights[i][0]).add(curr);  
        }
        
        
        while(q.size() != 0){
            Integer s = q.remove();
            
            for(ArrayList<Integer> nextEl: adjList.get(s)){
                
                for(int i = 0; i < count.get(s).size(); i++){
                    
                    Integer c = count.get(s).get(i);
                    if(c + 1 > K){
                        break;
                    }
                    count.get(nextEl.get(0)).add(c + 1);
                    dist.get(nextEl.get(0)).add(dist.get(s).get(i) + nextEl.get(1));
                    
                }
                
                if(!visited.contains(nextEl.get(0))){
                    //System.out.println("ADD "+nextEl.get(0));
                    q.add(nextEl.get(0));
                    visited.add(nextEl.get(0));
                }
            }
        }
        
        if(dist.get(dst).size() == 0){
            return -1;
        }else{
            Collections.sort(dist.get(dst));
            System.out.print(dist.get(dst));
            Integer min_dist = dist.get(dst).get(0);
            if(min_dist == Integer.MAX_VALUE){
                return -1;
            }
            return min_dist;
        }
        
    }
}
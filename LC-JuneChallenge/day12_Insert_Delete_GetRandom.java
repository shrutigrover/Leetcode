/**
Problem -  Insert Delete GetRandom

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

**/
/** Solution - 
HashSet is used as a DS to perform remove and insert in constant time. However, getRandom is implemented by converting hashset to array
that results in O(n) for get random operation. However, the solution was accepted.
This can be improved by using HashMap and Array where HashMap store val as key and its corresponding index in the list as value.

While removing, the val to be removed can be replaced by the last elemnet of the list in constant time and then last element can be removed.
**/

class RandomizedSet {

    private HashSet randomSet; 
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        randomSet = new HashSet();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(randomSet.contains(val)){
            return false;
        }
        randomSet.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randomSet.contains(val)){
            randomSet.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int i = (int)(Math.random()*randomSet.size());
        Object[] arr = randomSet.toArray();
        return (int)arr[i];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
/**
Problem - Search in a Binary Search Tree

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

Example -

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

O/P : 2     
     / \   
    1   3
**/

/**
Solution -
Use BST property to move to left or right of the tree.

Runtime: O(depth of the tree) = O(log base 2 n) when n are number of nodes in the binary search tree
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        while(root != null){
            if(root.val == val){
                return root;
            }
            
            if(val < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        
        return null;
    }
}
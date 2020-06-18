/**
Problem - Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region.

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

Example -
Input:
X X X X
X O O X
X X O X
X O X X

Output:
X X X X
X X X X
X X X X
X O X X
**/

/**
Solution -

The below solution uses DFS to determine which O's should be replced by X's. 

Idea is to first find O's adjoining/connecting O's at borders(done by DFS). Replace these to some proxy value(here 'S').
Then replace the other inner O's with X's. and 'S' with Os.

Runtime - O(rows*cols) - each value in the board is traversed
Space - O(rows*cols) - stack


**/

class Solution {
    
    public void dfs(char[][] board, int i, int j){
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'S'){
            return; 
        }
        
        board[i][j] = 'S';
        
        dfs(board, i-1 , j);
        dfs(board, i+1 , j);
        dfs(board, i , j-1);
        dfs(board, i , j+1);
    }
    
    public void solve(char[][] board) {
        
        if(board.length == 0){
            return;
        }
        
        //handle the border O's and connectes O's with it using DFS
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            
            if(board[i][cols-1] == 'O'){
                dfs(board, i, cols-1);
            }
        }
        
        for(int i = 0; i < cols; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[rows - 1][i] == 'O'){
                dfs(board, rows - 1, i);
            }
        }
        
		//replace outer S's with O's and inner O's with X's
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++ ){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
}
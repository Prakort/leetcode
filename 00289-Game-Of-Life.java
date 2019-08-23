/*

cell 1 -- n < 2 --> die 0
cell 1 -- n=2 or 3 --> live 1
cell 1 -- n>3 --> die 0
cell 0 --n ==3 --> live 1

two for loop and find the live cell 1 all around the current cell
using neightbors [0,-1,1]

add sum if it cell 1

using -1 as temp for die cell
using 1 , 2 as temp for live cell


*/


class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int []n = {-1,0,1};
        
        for ( int row = 0 ; row < rows ; row++)
        {
            for ( int col = 0 ; col < cols ; col++){
                
                int counter = 0;
                
                
                for ( int i = 0 ; i <3 ; i ++)
                {
                    for ( int j = 0; j < 3; j++)
                    {
                        
                        if( !(n[i]==0 && n[j]==0))
                        {
                            int r = row + n[i];
                            int c = col + n[j];
                            
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) &&(Math.abs(board[r][c]) == 1))
                                counter+=1;
                        }
                        
                    }
                }
                
                
                if( board[row][col]==1 &&(counter <2 || counter>3))
                {
                     board[row][col]=-1;
                }
                if( board[row][col]==0 && counter==3)
                    board[row][col]=2;
            }
        }
       for ( int row = 0 ; row < rows ; row++)
        {
            for ( int col = 0 ; col < cols ; col++){
                
                if(board[row][col]>0)
                    board[row][col]=1;
                else
                    board[row][col]=0;
            }}
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        boolean visited[][] = new boolean[rows][cols];
        
        char[] w = word.toCharArray();
        
            for( int i = 0 ; i < rows ; i++)
            {
                for(int j = 0 ; j < cols ; j++)
                {
                    if (helper(board,visited,i,j,0,word))
                    {
                       return true;
                    }
                }
            }
        return false;
        
    }
    public boolean helper(char[][] board, boolean visited[][], int i , int j , int index,String word)
    {
        // base case
        if(word.length()==index)
            return true;
        
        // return false if index of out range or unmatched char
        if(i>=board.length || j >=board[0].length || i <0 || j <0 || board[i][j]!=word.charAt(index)|| visited[i][j])
            return false;
        
        // marked as visited char
        visited[i][j]=true;
        
        if(
        helper(board,visited,i,j+1,index+1,word) ||
        helper(board,visited,i,j-1,index+1,word) ||
        helper(board,visited,i+1,j,index+1,word) ||
        helper(board,visited,i-1,j,index+1,word) 
        ){
            
            return true;
        }
        
        // if it is unmatched mark as fault for next search
        
        visited [i][j]=false;
        
        return false;
        
       
    }
}
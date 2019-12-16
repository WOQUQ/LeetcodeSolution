package test70_79;


public class Test79 {
	static boolean[][] flags;
    public static boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) {
        	return word.equals("");
        }
        flags = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length;i++) {
        	for(int j = 0;j < board[0].length; j++) {
        		if(findNext(board,word,0,i,j)) return true;
        	}
        }
        return false;
        
        
    }
    private static boolean findNext(char[][] board, String word, int indexStr, int i, int j) {
    	if(!flags[i][j] && board[i][j] == word.charAt(indexStr)) {
    		if(indexStr == word.length()-1) return true;
    		
    		flags[i][j]  =true;
    		
    		boolean up = false;
    		boolean down = false;
    		boolean left = false;
    		boolean right = false;
    		if(i+1 < board.length) down = findNext(board,word,indexStr+1,i+1,j);
    		if(j+1 < board[0].length) right = findNext(board, word, indexStr+1, i, j+1);
    		if(i-1 >= 0 ) up = findNext(board, word, indexStr+1, i-1, j);
    		if(j-1 >= 0) left = findNext(board, word, indexStr+1, i, j-1);
    		
    		if(up || right || left || down) return true;
    		else {
    			flags[i][j] = false;
    			return false;
    		}
     		
    	}else {
    		return false;
    	}
    }
    
    public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "ABCCED";
		System.out.println(exist(board, word));
		
	}
}

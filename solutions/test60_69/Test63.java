package test60_69;

public class Test63 {
	/** 动态规划 **/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	if(m == 1 || n == 1 ) {
    		for(int i =0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				//if the only path is not clear, return 0
    				if(obstacleGrid[i][j] == 1) return 0;
    			}
    		}
    		return 1;
    	}
    	if(obstacleGrid[0][0] == 1) return 0;
    	
    	boolean blockX = false;
    	boolean blockY = false;
    	
        int[] curr = new int[n]; 
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			curr[j] = 0;
        			if(i == 0) blockX = true;
        			if(j == 0) blockY = true;
        			continue;
        		}
        		if( i == 0 ) {
        			if(!blockX) curr[j] = 1;
        			else curr[j] = 0;
        			continue;
        		}
        		if( j == 0 ) {
        			if(!blockY) curr[j] = 1;
        			else curr[j] = 0;
        			continue;
        		}
        		curr[j] += curr[j-1];
        	}
        }
        return curr[n - 1];
    }
}

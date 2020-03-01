package test80_89;

public class Test85 {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0) return 0;
    	int maxArea = 0;
    	int[] maxHeights = new int[matrix[0].length];
    	int[] maxLefts = new int[matrix[0].length];
    	int[] maxRights = new int[matrix[0].length];

    	
    	//check the max area for every matrix[i,j]
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			if(matrix[i][j] == '1') {
    				
    				//check the max height
    				if(i > 0 && matrix[i-1][j] == '1') {
    					maxHeights[j]++;
    					
    					//check the max left position
        				int temp = j;
        				while(temp >= 0 && matrix[i][temp] == '1' ) temp--;
        				if(temp+1 > maxLefts[j]) maxLefts[j] = temp+1;
        				
        				//check the max right position
        				temp = j;
        				while(temp < matrix[0].length && matrix[i][temp] == '1') temp++;
        				if(temp-1 < maxRights[j]) maxRights[j] = temp-1;
        				
    				}
    				else{
    	    			maxHeights[j] = 1;
    	    			
    	    			//check the max left position
    					int temp = j;
    					while(temp >= 0 && matrix[i][temp] == '1' ) temp--;
    					maxLefts[j] = temp+1;
    					
    					//check the max right position
    					temp = j;
    					while(temp < matrix[0].length && matrix[i][temp] == '1') temp++;
    					maxRights[j] = temp-1;
    					
    	    		}
    				
    				int temp = (maxRights[j] - maxLefts[j] + 1) * maxHeights[j];
    				if(temp > maxArea) maxArea = temp;
    			}
    		}
    	}
    	
    	
    	return maxArea;
    }
    
    //test
    public static void main(String[] args) {
    	char[][] matrix= new char[][]{
    			{'1','0','1','0','0'},
    			{'1','0','1','1','1'},
    			{'1','1','1','1','1'},
    			{'1','0','0','1','0'}
    };
		Test85 test85 = new Test85();
		System.out.println(test85.maximalRectangle(matrix));
    }
}

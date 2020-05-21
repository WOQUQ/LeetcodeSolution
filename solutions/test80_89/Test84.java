package test80_89;

import java.util.Stack;

public class Test84 {
	
	//分治
    public static int largestRectangleArea(int[] heights) {
    	int size = heights.length;
    	if(size == 0) return 0;
    	
    	return findLargestAreaInASegment(heights, 0, size - 1);
    }
    
    /**
     * 分治递归函数
     * @param heights
     * @param begin
     * @param end (= size - 1)
     * @return
     */
    private static int findLargestAreaInASegment(int[] heights, int begin, int end) {
    	
    	int heightMin = Integer.MAX_VALUE;
    	int indexMin = -1;
    	
    	//find the minimum height in the segment
    	for(int i = begin; i <= end; i++) 
    		if(heights[i] < heightMin) {
    			heightMin = heights[i];
    			indexMin = i;
    		}
    	
    	int area = (end - begin + 1) * heightMin;
    	int leftArea = -1;
    	int rightArea = -1;
    	
    	//deal with the segment in the left
    	if(begin == indexMin - 1) leftArea = heights[begin];
    	else if(begin < indexMin - 1) {
    		leftArea = findLargestAreaInASegment(heights, begin, indexMin - 1);
    	}
    	
    	//deal with the segment in the right
    	if(end == indexMin + 1) rightArea = heights[end];
    	else if(end > indexMin + 1) {
    		rightArea = findLargestAreaInASegment(heights, indexMin+1, end);
    	}
    	
    	return Math.max(area, Math.max(rightArea, leftArea));
    	
    }
    
    //test
    public static void main(String[] args) {
		int[] arr = {2,1,2};
		//System.out.println(largestRectangleArea(arr));
		System.out.println(largestRectangleAreaByStack(arr));
	}
    
    //单调栈
//    public static int largestRectangleAreaByStack(int[] heights) {
//    	if(heights.length == 0) return 0;
//    
//    	int areaMax = heights[0];
//    	Stack<Integer> stack = new Stack<>();
//    	stack.push(-1);
//    	stack.push(0);
//    	for(int i = 1; i < heights.length; i++) {
//    		//保持递增，将下标压入栈中
//    		if(stack.peek() == -1 || heights[stack.peek()] <= heights[i]) {
//    			stack.push(i);
//    		}else {
//    			while(stack.peek() == -1 || heights[stack.peek()] >= heights[i]) {
//    				if(stack.peek() == -1) {
//    					
//    				}
//    				int indexTemp = stack.pop();
//    				int areaTemp = (i - indexTemp)*heights[indexTemp];
//    				if(areaTemp > areaMax) areaMax = areaTemp;
//    			}
//    			stack.push(i);
//    		}
//    	}
//    	if(stack.peek() > -1) {
//    		int indexMax = stack.pop();
//    		if(heights[indexMax] > areaMax) areaMax = heights[indexMax];
//    		while(stack.peek() > -1) {
//    			int indexTemp = stack.pop();
//    			int areaTemp = (indexMax - indexTemp + 1)*heights[indexTemp];
//    			if(areaTemp > areaMax) areaMax = areaTemp;
//    		}
//    	}
//    	return areaMax;
//    	
//    }
    public static int largestRectangleAreaByStack(int[] heights) {
        Stack < Integer > stack = new Stack <Integer > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

}

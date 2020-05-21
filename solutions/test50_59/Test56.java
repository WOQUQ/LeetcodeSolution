package test50_59;

import java.util.ArrayList;
import java.util.Arrays;

public class Test56 {
    public static int[][] merge(int[][] intervals) {
    	if(intervals.length < 2) return intervals;
    	
        intervals = qsort(intervals,0,intervals.length-1);
        ArrayList<int[]> list = new ArrayList<int[]>();
        
        
        for(int i = 1; i < intervals.length; i++) {
        	if(intervals[i][0] <= intervals[i-1][1]) {
        		
        		intervals[i][0] = intervals[i-1][0];
        		if(intervals[i][1] < intervals[i-1][1]) intervals[i][1] = intervals[i-1][1];
        	}else {
        		list.add(intervals[i-1]);
        	}
    		if(i == intervals.length-1) {
    			list.add(intervals[i]);
    		}
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
        	res[i][0] = list.get(i)[0];
        	res[i][1] = list.get(i)[1];
        }
        return res;
        
    }
    
    public static int[][] qsort(int[][] arr,int begin,int end){
    	int medium = arr[begin][0];
    	int i = begin;
    	int j = end;
    	while(i<j) {
	    	while((i<j) && arr[j][0] > medium) j--;
	    	while((i<j) && arr[i][0] < medium) i++;
	    	
	    	if((i<j) && arr[i][0] == arr[j][0]) i++;
	    	else {
	    		int[] temp = new int[2]; 
	    		temp[0] = arr[i][0];
	    		temp[1] = arr[i][1];
	    		arr[i][0] = arr[j][0];
	    		arr[i][1] = arr[j][1];
	    		arr[j][0] = temp[0];
	    		arr[j][1] = temp[1];
	    	}
    	}
    	if(i-1 > begin) arr = qsort(arr,begin,i-1);
    	if(j+1 < end) arr = qsort(arr,j+1,end);
    	
    	return arr;
    	
    }
    public static void main(String[] args) {
		int[][] arr = {{2,6},{1,3},{15,18},{8,10}};
		arr = merge(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}
}

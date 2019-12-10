package test30_39;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @author WOQUQ
 *
 */
public class Test32 {
	/** 算法1 栈 **/
    public static int longestValidParentheses(String s) {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(-1);
    	
    	int res = 0;
        int size = s.length();
        char temp;
        int begin;
        for(int i = 0; i < size; i++) {
        	temp = s.charAt(i);
        	
        	if(temp == '(') stack.push(i);//将‘（’de下标推入栈中
        	else if(temp == ')') {
        		//释放栈顶
        		stack.pop();
        		
        		//如检测到栈为空，将当前i推入栈中作为计数起点
        		if(stack.isEmpty()) stack.push(i);
        		//如栈不为空，则从栈顶获得计数起点
        		else{
        			begin = stack.peek();
        			if(i - begin > res) res = i - begin;
        		}
        	}
        }
        
        return res;
    }
    
    /** 算法2 动态规划 **/
    public static int longestValidParentheses2(String s) {
    	int size = s.length();
    	int[] arr = new int[size];
    	int res = 0;
    	for(int i = 1; i < size; i++) {
    		if(s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
    			arr[i] = (i > 2) ? arr[i - 2] + 2 : arr[i - 1] + 2;
    			if(arr[i] > res) res = arr[i];
    		}else if(s.charAt(i) == ')' && s.charAt(i - 1) == ')' && i - arr[i - 1] - 1 >= 0 && s.charAt(i - arr[i - 1] - 1) == '(') {
    			arr[i] = i - arr[i - 1] - 2 >= 0 ?
    					arr[i-1] + arr[i - arr[i - 1] -2] + 2:
    						arr[i - 1] + 2;
    			if(arr[i] > res) res = arr[i];
    		}
    	}
    	return res;
    }
    
    /** 算法3 二次遍历双计数器 **/
    public static int longestValidParentheses3(String s) {
    	int size = s.length();
    	int left = 0;
    	int right = 0;
    	int res = 0;
    	for(int i = 0; i < size; i++) {
    		if(s.charAt(i) == '(') left++;
    		else right++;
    		
    		if(left == right && left*2 > res) res = left*2;
    		else if(left < right) {
    			left = 0;
    			right = 0;
    		}
    	}
    	left = 0;
    	right = 0;
    	for(int i = size - 1; i >= 0; i--) {
    		if(s.charAt(i) == ')') right++;
    		else left++;
    		
    		if(left == right && left*2 > res) res = left*2;
    		else if(right < left) {
    			left = 0;
    			right = 0;
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		System.out.println(longestValidParentheses3(")()())"));
	}
}

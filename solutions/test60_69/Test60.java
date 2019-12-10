package test60_69;

import java.util.ArrayList;


/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
 * @author WOQUQ
 *
 */
public class Test60 {
    public static String getPermutation(int n, int k) {
    	if(n == 1) return "1";
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 1; i < n+1; i++) list.add(i);
    	
    	String res = "";
    	
    	while(list.size()>1) {
    		int tempIndex = count(k,help(n-1));
    		int temp = list.get(tempIndex);
    		res += temp;
    		list.remove(tempIndex);
    		k = leave(k,help(n-1));
    		n--;
    	}
    	res += list.get(0);
        return res;
        
    }
    private static int help(int n) {
    	int res = n;
    	n--;
    	while(n>0) {
    		res *= n;
    		n--;
    	}
    	return res;
    }
    
    private static int count(int m, int n) {
    	int res=0;
    	while(m>n) {
    		m -= n;
    		res++;
    	}
    	return res;
    }
    private static int leave(int m,int n) {
    	while(m>n) {
    		m -= n;
    	}
    	return m;
    }
    
    public static void main(String[] args) {
		System.out.println(getPermutation(3, 2));
		//System.out.println(help(2));
		//System.out.println(count(9,6));
	}
}

package test10_19;

import java.util.HashMap;

/**
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @author WOQUQ
 *
 */
public class Test13 {
	/** 从头至尾遍历，先找两个字符，再找一个一个字符 **/
//    public static int romanToInt(String s) {
//    	int res = 0;
//        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};      
//        int i = 0;
//        char temp1;
//        char temp2;
//        String temp;
//        test : while(i < s.length()) {
//        	temp = "";
//        	temp1 = s.charAt(i);
//
//        	if((temp1 == 'C' || temp1 == 'X' || temp1 == 'I') && i < s.length()- 1) {
//        		temp2 = s.charAt(i+1);
//        		temp = String.valueOf(temp1) + String.valueOf(temp2);
//        	}
//        	for(int j = 0;j < 13; j++) {
//        		if(temp != "" && romans[j].equals(temp)) {
//        			res += nums[j];
//        			i += 2;
//        			continue test;
//        		}
//        	}
//        	for(int j = 0;j < 13; j++) {
//        		if(romans[j].equals(String.valueOf(temp1))) {
//        			res += nums[j];
//        			i++;
//        			continue test;
//        		}
//        	}
//        	
//        }
//        return res;
//    }
	/**  **/
    public static int romanToInt(String s) {
    	int res = 0;
//    	int[] nums = {1000,800,500,300,100,80,50,30,10,8,5,3,1};
//    	String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}; 
    	HashMap<String,Integer> map = new HashMap<>();
    	map.put("M", 1000);
    	map.put("CM", 800);
    	map.put("D", 500);
    	map.put("CD", 300);
    	map.put("C", 100);
    	map.put("XC", 80);
    	map.put("L", 50);
    	map.put("XL", 30);
    	map.put("X", 10);
    	map.put("IX", 8);
    	map.put("V", 5);
    	map.put("IV", 3);
    	map.put("I", 1);
    	
    	String temp = String.valueOf(s.charAt(0));
    	res += map.get(temp);
    	
    	for(int i = 1; i < s.length(); i++) {
    		temp = String.valueOf(s.charAt(i-1)) + String.valueOf(s.charAt(i));
    		if(map.containsKey(temp)) res += map.get(temp);
    		else {
    			temp = String.valueOf(s.charAt(i));
    			res += map.get(temp);
    		}
    	}
    	return res;

    }
//    class Solution {
//        public int romanToInt(String s) {
//            int res = 0;
//    	for (int i = s.length() - 1; i >= 0; i--) {
//    		char c = s.charAt(i);
//    		switch (c) {
//    		case 'I':
//    			res += (res >= 5 ? -1 : 1);
//    			break;
//    		case 'V':
//    			res += 5;
//    			break;
//    		case 'X':
//    			res += 10 * (res >= 50 ? -1 : 1);
//    			break;
//    		case 'L':
//    			res += 50;
//    			break;
//    		case 'C':
//    			res += 100 * (res >= 500 ? -1 : 1);
//    			break;
//    		case 'D':
//    			res += 500;
//    			break;
//    		case 'M':
//    			res += 1000;
//    			break;
//    		}
//    	}
//    	return res;
//        }
//    }
    public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}

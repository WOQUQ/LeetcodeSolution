package test10_19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author WOQUQ
 *
 */
public class Test17 {
    public static List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<String>();
    	int size = digits.length();
    	if(size == 0) return res;
    	
        char[] str2 = {'a','b','c'};
        char[] str3 = {'d','e','f'};
        char[] str4 = {'g','h','i'};
        char[] str5 = {'j','k','l'};
        char[] str6 = {'m','n','o'};
        char[] str7 = {'p','q','r','s'};
        char[] str8 = {'t','u','v'};
        char[] str9 = {'w','x','y','z'};
        HashMap<Integer,char[]> map = new HashMap<Integer,char[]>();
        map.put(2, str2);
        map.put(3, str3);
        map.put(4, str4);
        map.put(5, str5);
        map.put(6, str6);
        map.put(7, str7);
        map.put(8, str8);
        map.put(9, str9);
        
        for(int i= 0; i < size; i++) {
        	int tempInt = Integer.parseInt(String.valueOf(digits.charAt(i)));
        	char[] tempStr = map.get(tempInt);
        	res = addNewStr(res, tempStr);
        }
        
        return res;
        
    }
    
    
    private static List<String> addNewStr(List<String> res,char[] str) {
        int size = str.length;
        if(size == 0) return res;
        
        if(res.size() == 0) {
        	for(int i = 0; i < size; i++) {
        		res.add(String.valueOf(str[i]));
        	}
        	return res;
        }
        
        List<String> newList = new ArrayList<String>();
        for(int i = 0; i < res.size(); i++) {
        	String temp = res.get(i);
        	for(int j = 0; j < size; j++) {
        		newList.add(temp+String.valueOf(str[j]));
        	}
        }
        
        return newList;

    }    
    
    public static void main(String[] args) {
//    	List<String> res = new ArrayList<String>();
//    	res.add("test1");
//    	res.add("test2");
//    	res.add("test3");
    	
//    	char[] str = {'a','b','c'};
		System.out.println(letterCombinations("23"));
	}
    
}

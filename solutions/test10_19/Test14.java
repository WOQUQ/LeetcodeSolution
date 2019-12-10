package test10_19;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""
 * @author WOQUQ
 *
 */
public class Test14 {
    public static String longestCommonPrefix(String[] strs) {
        //int size = strs.length;
    	if(strs.length == 0) return "";
    	StringBuilder res = new StringBuilder();
    	int strIndex = 0;
    	big:while(true) {
    		if(strIndex >= strs[0].length()) break;
    		char temp = strs[0].charAt(strIndex);
    		for(int i = 1; i < strs.length; i++) {
    			if(strIndex >= strs[i].length() || strs[i].charAt(strIndex) != temp) break big;
    		}
    		res.append(String.valueOf(temp));
    		strIndex++;
    	}
    	return res.toString();
        
    }
    
    public static void main(String[] args) {
    	String[] strs = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(  strs ));
	}
}

package test40_49;
/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
 * @author WOQUQ
 *
 */
public class Test44 {
	/** 解法1 递归遍历 **/
	//递归太过频繁，大量建立子串导致速度慢，可以考虑每次遇见*时再进行下一次递归
//    public static boolean isMatch(String s, String p) {
//    	if(s.length() == 0 && p.length() == 0) return true;
//    	else if(s.length() == 0) {
//    		for(int i = 0; i < p.length(); i++) {
//    			if(p.charAt(i) != '*') return false;
//    		}
//    		return true;
//    	}
//    	else if(p.length() == 0) return false;
//    	
//    	
//        char s_temp = s.charAt(0);
//        char p_temp = p.charAt(0);
//        
//        if(s_temp == p_temp || p_temp == '?') return isMatch(s.substring(1),p.substring(1));
//        
//        if(p_temp == '*') {
//        	if(p.length() == 1) return true;
//        	int count = 1;
//        	while(count<p.length() && p.charAt(count) == '*') count++;
//        	if(count>= p.length() ) return true;
//        	
//        	p_temp = p.charAt(count);
//        	
//        	for(int i = 0; i < s.length();i++) {
//        		if( (s.charAt(i) == p_temp || p_temp == '*' || p_temp == '?') && isMatch(s.substring(i),p.substring(count))) return true;
//        	}
//        	return false;
//        }
//        
//        return false;
//    }
	/** 解法二 动态规划 **/
//    public static boolean isMatch(String s, String p) {
//        
//    }
//    public static void main(String[] args) {
//		System.out.println(isMatch("abbbb","?*b**"));
//	}
}

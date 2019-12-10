package test10_19;
/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * @author WOQUQ
 *
 */
public class Test10 {
	static boolean flag = false;
	static boolean flagChange = true;
	
    public static boolean isMatch(String s, String p) {
    	if(s.length() == 0 && p.length() == 0) return true;
    	else if(p.length() == 0) return false;
    	
    	return  matchHelper(s,p,0,0);
    }
    
    private static boolean matchHelper(String s,String p, int sBegin, int pBegin) {
    	if(sBegin >= s.length() && pBegin >= p.length()) return true;
    	else if(pBegin >= p.length()) {
    		if(p.charAt(p.length() - 1) == '*') {
    			if(p.charAt(p.length() - 2) == '.') return true;
    			while(sBegin < s.length()) {
    				if(s.charAt(sBegin) != p.charAt(p.length() - 2)) {
    					return false;
    				}
    				sBegin++;
    			}
    			return true;
    		}
    		
    		return false;
    	}
    	else if(sBegin >= s.length()) {
    		if(s.length() == 0) {
        		while(pBegin < p.length()) {
        			if(p.charAt(pBegin) != '*' && (pBegin + 1 >= p.length() || p.charAt(pBegin + 1) != '*')) {
        				return false;
        			}
        			pBegin++;
        		}
        		return true;
    		}
    			
    		
    		while(pBegin < p.length() - 1) {
    			if(p.charAt(pBegin) != '*' && (pBegin + 1 >= p.length() || p.charAt(pBegin + 1) != '*')) {
    				return false;
    			}
    			pBegin++;
    		}
    		if(p.charAt(p.length() - 1) != '*' && (!flag || s.charAt(s.length() - 1) != p.charAt(p.length() - 1))) return false;
    		//else if(p.charAt(p.length() - 1) == '*' && )
    		return true;
    	}
    	
        char s_temp = s.charAt(sBegin);
        char p_temp = p.charAt(pBegin);
        
        if(s_temp == p_temp || p_temp == '.') {
        	if(flagChange) flag  =false;
        	else flagChange = true;
        	
        	return matchHelper(s,p,sBegin+1,pBegin+1);
        	
        }
        else if(p.charAt(pBegin) == '*') {
        	flag = true;
        	flagChange = false;
        	
        	return matchHelper(s,p,sBegin,pBegin - 1);
        }       
        else if(pBegin+1<p.length() && p.charAt(pBegin+1) == '*') {
        	if(flagChange) flag  =false;
        	else flagChange = true;
        	
        	return matchHelper(s,p,sBegin,pBegin+2);
        }

        else {
        	return false;
        } 	
    }
    
    public static void main(String[] args) {
		System.out.println(isMatch("ab",".*.."));
	}
}
/**
class Solution {
public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) return text.isEmpty();
    boolean first_match = (!text.isEmpty() &&
                           (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        return (isMatch(text, pattern.substring(2)) ||
                (first_match && isMatch(text.substring(1), pattern)));
    } else {
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}
}

enum Result {
    TRUE, FALSE
}

class Solution {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                       first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
*/
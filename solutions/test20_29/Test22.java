package test20_29;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 * @author WOQUQ
 *
 */
public class Test22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0) res.add("");
        else {
        	for(int i = 0; i < n; i++)
        		for(String left :generateParenthesis(i))
        			for(String right:generateParenthesis(n-1-i))
        				res.add("("+left+")"+right);
        }
        return res;
        
    }
}

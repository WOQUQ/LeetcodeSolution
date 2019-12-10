package test20_29;

import java.util.Stack;



/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 * @author WOQUQ
 *
 */
public class Test20 {
    public static boolean isValid(String s) {
        int size = s.length();
        if(size == 0) return true;
        
        Stack<Character> stack = new Stack<Character>();
        char compare;
        for(int i = 0; i < size; i++) {
        	char temp = s.charAt(i);
        	if(temp == '(' || temp == '{' || temp == '[') stack.push(temp);
        	else {
        		if(stack.isEmpty()) return false;
        		switch (temp) {
				case ')':
					compare = stack.pop();
					if(compare != '(') return false;
					break;
				case '}':
					compare = stack.pop();
					if(compare != '{')  return false;
					break;
				case ']':
					compare = stack.pop();
					if(compare != '[') return false;
					break;					
				default:
					return false;
					
				}
        	}
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args) {
		System.out.println(isValid("["));
	}
}

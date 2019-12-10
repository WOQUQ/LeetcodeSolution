package test1_9;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 * @author WOQUQ
 *
 */
public class Test6 {
    public static String convert(String s, int numRows) {
    	if(numRows == 1) return s;
        List<StringBuffer> rows = new ArrayList<StringBuffer>(numRows);
       for(int i = 0; i < numRows; i++) rows.add(new StringBuffer());
        
        boolean flag = true;
        int rowIndex = 1;
        rows.get(0).append(String.valueOf(s.charAt(0)));
        for(int i = 1; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	rows.get(rowIndex).append(String.valueOf(temp));
        	
        	if(rowIndex == 0 || rowIndex == numRows-1) flag = !flag;
        	if(flag) rowIndex++;
        	else rowIndex--;
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < numRows; i++) {
        	res.append(rows.get(i));
        }
        
        return res.toString(); 
    }
    
    public static void main(String[] args) {
		System.out.println(convert("LEETCODEISHIRING", 4));
	}
}

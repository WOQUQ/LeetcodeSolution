package test1_9;
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

基本思路： 先编写判断字符串是否是回文字符串的函数，接着利用滑动窗口，左窗口一层遍历，
从左至右，右窗口二层遍历，从右至左，记录最长回文字符串长度，当判断不可能刷新最长时，跳过余下判断，直接进入下一层循环

方法三：动态规划
为了改进暴力法，我们首先观察如何避免在验证回文时进行不必要的重复计算。考虑 \textrm{“ababa”}“ababa” 这个示例。如果我们已经知道 \textrm{“bab”}“bab” 是回文，那么很明显，\textrm{“ababa”}“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的。

这产生了一个直观的动态规划解法，我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推…

复杂度分析

时间复杂度：O(n^2)O(n 
2
 )，这里给出我们的运行时间复杂度为 O(n^2)O(n 
2
 ) 。

空间复杂度：O(n^2)O(n 
2
 )，该方法使用 O(n^2)O(n 
2
 ) 的空间来存储表。

方法四：中心扩展算法
事实上，只需使用恒定的空间，我们就可以在 O(n^2)O(n 
2
 ) 的时间内解决这个问题。

我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。

你可能会问，为什么会是 2n−1 个，而不是 n 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）。

 */
public class Test5 {
//	public static String longestPalindrome(String s) {
//        int left = 0;//滑动窗口的左窗口
//        int right = s.length()-1;//滑动窗口的右窗口
//        int max = 0;//记录目前得到的最长回文子串长度
//        String res = "";//记录目前得到的最长回文子串
//        
//        //如果检测到s 长度为1，直接返回s
//        if(s.length() == 1) {
//        	return s;
//        }
//        
//        //左窗口从左至右第一层遍历
//        for(int i = 0; i < s.length(); i++) {
//        	//如果检测到左窗口至s末端的长度已经比max小，则直接退出循环
//        	if(s.length() - i <= max) {
//        		break;
//        	}
//        	
//        	//右窗口从右至左第二层遍历
//        	for(int j = s.length()-1; j >= i; j--) {
//        		//若检测到左窗口到右窗口的长度已经小于等于max。则直接退出循环
//        		if(j - i + 1 <= max) {
//        			break;
//        		}
//        		
//        		//检测左窗口至右窗口的字符创是否是回文字符串，若是，则与max做比较并更新res
//        		int temp = checkStr(s.substring(i, j+1));
//        		if(temp > max) {
//        			max = temp;
//        			res = s.substring(i, j+1);
//        		}
//        	}
//        	
//        }
//        return res;
//        
//    }
//	
//	public static int checkStr(String str) {
//		//将str长度除2得到左半长度与右半长度，对于奇偶数均适用
//		int half = str.length()/2;
//		
//		//分别从str的头尾判断0至第half位的字符是否相等
//		for(int i = 0; i < half; i++) {
//			//如果检测到不相等，返回-1
//			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
//				return -1;
//			}
//		}
//		//如果全部都符合条件，则说明本字符串是回文字符串，返回其长度
//		return str.length();
//	}
	/** 应该操作下标而不是创建字符串**/
//	/** 以下尝试中心扩展算法**/
//	public static String longestPalindrome(String s) {
//		if(s.length() == 0) {
//			return "";
//		}
//		String res = "";
//		res += s.charAt(0);
//		
//		//由左至右一层遍历，遍历每一个可能的中心点，包括一个数的与两数之间的
//		for(int i = 0; i < s.length(); i++) {
//			String temp = checkCenter(s,i);
//			if(temp.length() > res.length()) {
//				res = temp;
//			}
//			temp = checkCenter(s,i,i+1);
//			if(temp.length() > res.length()) {
//				res = temp;
//			}
//		}
//		return res;
//	}
//	/**
//	 * 针对中央位于一个数上的情况
//	 * @param str
//	 * @param center
//	 * @return
//	 */
//	public static String checkCenter(String str, int center) {
//		
//		String res = "";
//		res += str.charAt(center);
//		
//		//从中央向两边检测 center+i 和center-i
//		for(int i = 1; ;i++) {
//			//如果center+i 或者center-i超出范围，则直接退出循环
//			if( (center-i < 0) || ( (center + i) > (str.length()-1) ) ) {
//				break;
//			}
//			
//			//判断位于center+i 与center-i处的字符是否相等，若不相等，则直接退出循环
//			if(str.charAt(center-i) !=  str.charAt(center+i)) {
//				break;
//			}
//			//若相等，则将这两个字符加在res的两端
//			res = str.charAt(center-i) + res + str.charAt(center+i);
//		}
//		
//		return res;
//
//	}
//	/**
//	 * 针对中央位于两个数之间的情况
//	 * @param str
//	 * @param center1
//	 * @param center2
//	 * @return
//	 */
//	public static String checkCenter(String str, int center1, int center2) {
//		String res = "";
//		
//		//从中央向两边检测 center2+i 和center1-i
//		for(int i = 0; ;i++) {
//			//如果center+i 或者center-i超出范围，则直接退出循环
//			if( (center1-i < 0) || ( (center2 + i) > (str.length()-1) ) ) {
//				break;
//			}
//			
//			//判断位于center+i 与center-i处的字符是否相等，若不相等，则直接退出循环
//			if(str.charAt(center1-i) !=  str.charAt(center2+i)) {
//				break;
//			}
//			//若相等，则将这两个字符加在res的两端
//			res = str.charAt(center1-i) + res + str.charAt(center2+i);
//		}
//		
//		return res;
//
//	}
public static String longestPalindrome(String s) {
	if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}
}

package test1_9;

import java.util.HashMap;

public class Test3 {
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int begin = 0;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length();i++) {
			if(result > s.length() - begin) {
				break;
			}
			char nextOne = s.charAt(i);
			if(map.containsKey(nextOne)) {
				result = (i - begin) > result ? (i-begin) : result;
				begin = map.get(nextOne) + 1;
				map.clear();
				i = begin - 1;
				continue;
			}
			map.put(nextOne, i);
		}
		
			result = (s.length() - begin) > result? (s.length() - begin):result;

		return result;
		
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
}

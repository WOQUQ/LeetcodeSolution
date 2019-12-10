package test40_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> indexes = new ArrayList<String>();
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
        	String temp = strs[i];
        	String index = getIndex(temp);
        	if(map.containsKey(index)) {
        		map.get(index).add(temp);
        	}else {
        		ArrayList<String> list = new ArrayList<String>();
        		list.add(temp);
        		map.put(index, list);
        		indexes.add(index);
        	}
        }
        
        for(int i = 0 ; i < indexes.size(); i++) {
        	String temp = indexes.get(i);
        	res.add(map.get(temp));
        }
        
        return res;
        
        
    }
    
    private String getIndex(String s) {
    	int[] nums = new int[26];

    	for(int i = 0; i < s.length(); i++) {
    		char temp = s.charAt(i);
    		nums[Integer.valueOf(temp)-97]++;
    	}
    	StringBuilder str = new StringBuilder();
    	for(int i = 0; i < 26; i++) {
    		str.append('#');
    		str.append(nums[i]);
    	}
    	return str.toString();
    }
    public static void main(String[] args) {
		Test49 test = new Test49();
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(test.groupAnagrams(arr));
	}
}

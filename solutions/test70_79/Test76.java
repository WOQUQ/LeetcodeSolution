package test70_79;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class Test76 {

    public String minWindow(String s, String t) {
    	if(s.length() == 0 || t.length() == 0) return "";
        HashMap<Character,Integer> map = new  HashMap<Character,Integer>();
        for(int i = 0; i < t.length(); i++) {
        	Character temp = t.charAt(i);
        	if(map.containsKey(temp)) map.replace(temp, map.get(temp)+1);
        	else map.put(temp, 1);
        }
        
        ArrayList<Pair<Character,Integer>> list = getSampleList(s, map);
        //System.out.println(list);
        
        int begin = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int minBegin = 0;
        int minEnd = 0;
        while(true) {
	        while( end<list.size() && !checkStr(list,map,begin,end)) end++;
	        if(end >= list.size() && !checkStr(list,map,begin,end-1)) break;
	        
	        while(checkStr(list,map,begin,end)) begin++;
        	int temp = list.get(end).getValue() - list.get(begin-1).getValue() + 1;
        	if(temp < min) {
        		min = temp;
        		minBegin = begin-1;
        		minEnd = end;
        	}
        
        	if(end >= list.size()) break;
        }
        if(min == Integer.MAX_VALUE) return "";
        String res = s.substring(list.get(minBegin).getValue(), list.get(minEnd).getValue()+1);
        return res;
        
    }
    
    public ArrayList<Pair<Character,Integer>> getSampleList(String s,HashMap<Character,Integer> map) {
    	ArrayList<Pair<Character,Integer>> list = new ArrayList<>();
    	for(int i = 0; i < s.length(); i++) {
    		Character temp = s.charAt(i);
    		if(map.containsKey(temp)) list.add(new Pair<Character,Integer>(temp,i));
    	}
    	return list;
    }
    
    public boolean checkStr(ArrayList<Pair<Character,Integer>> list, HashMap<Character,Integer> map, int begin, int end) {
    	HashMap<Character,Integer> countMap = new HashMap<>();
    	for(int i = begin; i < end+1; i++) {
        	Character temp = list.get(i).getKey();
        	if(countMap.containsKey(temp)) countMap.replace(temp, countMap.get(temp)+1);
        	else countMap.put(temp, 1);
    	}
    	if(countMap.size() != map.size()) return false;
    	Set<Character> set = map.keySet();
    	for(Character c : set) {
    		if(!countMap.containsKey(c)) return false;
    		if(countMap.get(c) < map.get(c)) return false;
    	}
    	return true;
    	
    }
    public static void main(String[] args) {
		Test76 test = new Test76();
		System.out.println(test.minWindow("a", "aa"));
	}
}

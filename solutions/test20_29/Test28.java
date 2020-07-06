package test20_29;

import java.util.HashMap;

public class Test28 {
    // Sunday
    public int strStr(String haystack, String needle) {
        char[] temp = needle.toCharArray();
        if(temp.length < 1) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i < temp.length; i++){
            map.put(temp[i], i);
        }

        for(int i = 0; i <= haystack.length() - temp.length; ){

            for(int j = 0; j < temp.length; j++){
                if(temp[j] != haystack.charAt(i+j)) break;
                if(j == temp.length - 1){
                    return i;
                }
            }
            
            i += temp.length - 1;
            do{
                i++;
                if(i>=haystack.length()) return -1;
            }while(!map.containsKey(haystack.charAt(i)));
            i -= map.get(haystack.charAt(i));
        }
        return -1;
    }

    // test
    public static void main(String[] args) {
        Test28 test = new Test28();
        System.out.println(test.strStr("mdfnskfn", "a"));
    }
}
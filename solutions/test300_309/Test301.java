package test300_309;

import java.util.*;

public class Test301 {

    // BFS
    Set<String> _set = new LinkedHashSet<String>();

    public List<String> removeInvalidParentheses(String s) {
        if(checker(s)){
            ArrayList<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }

        Set<String> currSet = new LinkedHashSet<String>();
        currSet.add(s);
        bfs(currSet);
        ArrayList<String> res = new ArrayList<String>(_set.size());
        for(String temp : _set){
            res.add(temp);
        }
        return res;
    }
    
    private void bfs(Set<String> currSet){
        Set<String> nextSet = new LinkedHashSet<String>();
        for(String s : currSet){

            if(s.length() <= 1){
                if(s.equals("(") || s.equals(")")){
                    continue;
                }
                _set.add(s);
            }
            else{
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                        StringBuffer temp = new StringBuffer();
                        if(i > 0)
                            temp.append(s.substring(0, i));
                        if(i < s.length() - 1)
                            temp.append(s.substring(i+1, s.length()));
                        
                        String str = temp.toString(); 
                        if(checker(str)){
                            _set.add(str);
                        }else{
                            nextSet.add(str);
                        }
                    }
                }
            }
        }

        if( _set.isEmpty()){
            if(nextSet.isEmpty()){
                _set.add("");
                return;
            }
            bfs(nextSet);
        }

    }

    private boolean checker(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == '(')
                stack.add(temp);
            else if (temp == ')') {
                if (stack.isEmpty())
                    return false;

                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;

        return false;
    }

    // DFS



    public static void main(String[] args) {
        Test301 test = new Test301();
        System.out.println(test.removeInvalidParentheses("()"));
    }
}
package test200_209;

import java.util.HashMap;


    class Trie {
        boolean isEnd;
        HashMap<Character,Trie> map;
        /** Initialize your data structure here. */
        public Trie() {
            this.map = new HashMap<Character,Trie>();
            this.isEnd = false;
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word.isEmpty()){
                if(!this.isEnd)
                    isEnd = true;
                return;
            }
            char curr = word.charAt(0);
            word = word.substring(1);
            
            if(map.containsKey(curr)){
                map.get(curr).insert(word);
            }else{
                Trie next = new Trie();
                this.map.put(curr, next);
                // this.isEnd = false;
                next.insert(word);        
            }
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if(word.isEmpty()){
                return isEnd;
            }
            char curr = word.charAt(0);
            if(!this.map.containsKey(curr)) return false;
            word = word.substring(1);
            return this.map.get(curr).search(word);
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(prefix.isEmpty()) return true;
            
            char curr = prefix.charAt(0);
            if(!this.map.containsKey(curr)) return false;
            prefix = prefix.substring(1);
            return this.map.get(curr).startsWith(prefix);
        }   
                public static void main(String[] args) {
                    Trie obj = new Trie();
                    obj.insert("apple");
                    boolean param_2 = obj.search("app");
                    System.out.println(param_2);
                }
    } 


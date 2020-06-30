package Offer;

import java.util.Stack;

public class Test09 {
    class CQueue {
        Stack<Integer> stackAppend;
        Stack<Integer> stackDelete;
        public CQueue() {
            this.stackAppend = new Stack<Integer>();
            this.stackDelete = new Stack<Integer>();
        }
        
        public void appendTail(int value) {
            stackAppend.push(value);
        }
        
        public int deleteHead() {
            if(stackDelete.isEmpty()){
                if(stackAppend.isEmpty()) return -1;
                while(!stackAppend.isEmpty()){
                    stackDelete.push(stackAppend.pop());
                }

            }

            return stackDelete.pop();
        }
    }
}
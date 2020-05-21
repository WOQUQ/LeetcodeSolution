package test150_159;

import java.util.Stack;

class Test155{
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> mins;
        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<Integer>();
            this.mins = new Stack<Integer>();
        }
        
        public void push(int x) {
            stack.push(x);
            if(mins.empty()) 
                mins.push(x);
            else{
                int tempMin = mins.peek();
                tempMin = Math.min(tempMin, x);
                mins.push(tempMin);
            }
        }
        
        public void pop() {
            stack.pop();
            mins.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return mins.peek();
        }
    }
}
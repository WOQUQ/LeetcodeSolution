package test30_39;

import java.util.LinkedList;
import java.util.Queue;

public class Test38 {
    public String countAndSay(int n) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        for(; n > 1; n--){
            int compare = queue.peek();
            int count = 0;
            // int pre = 1;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int temp = queue.poll();
                if(temp == compare){
                    count++;
                    if(i != size -1) continue;
                }
                queue.add(count);
                queue.add(compare);
                if(temp != compare && i == size -1){
                    queue.add(1);
                    queue.add(temp);
                }
                compare = temp;
                count = 1;
            }
        }
        
        StringBuffer buffer  = new StringBuffer();
        while(!queue.isEmpty()){
            buffer.append(queue.poll());
        }
        return buffer.toString();
    }   

    // test
    public static void main(String[] args) {
        Test38 test = new Test38();
        System.out.println(test.countAndSay(6));
    }
}
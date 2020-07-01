package test550_559;

public class Test557 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        for(int i = 0; i <= arr.length;i++){
            if( i == arr.length || arr[i] == ' ' ){
                reverse(arr, start, i-1);
                start = i+1;
            }
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
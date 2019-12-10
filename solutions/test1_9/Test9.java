package test1_9;
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author WOQUQ
 *
 */
public class Test9 {
    public static boolean isPalindrome(int x) {
    	if(x < 0) return false;
    	if(x < 10) return true;
    	if(x%10 == 0) return false;
    	
        int temp = 0;
        while(x > temp) {
        	temp = temp*10 + x % 10;
        	x /= 10;
        }
        if(x == temp) return true;
        if(temp < 10) return false;
        temp /= 10;
        if(x == temp) return true;
        return false;
        
    }
    public static void main(String[] args) {
		System.out.println(isPalindrome(21120));
	}
}

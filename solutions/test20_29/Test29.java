package test20_29;
/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。
 * @author WOQUQ
 *
 */
public class Test29 {
    public static int divide(int dividend, int divisor) {
        boolean sign = !((dividend > 0) ^ (divisor > 0));
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
        
        int res = 0;
        
        while(divisor >= dividend) {
	        int temp = divisor;
	        int count = 1;
	        while(temp >= dividend) {
	        	dividend -= temp;
	        	res += count;
	        	temp = temp << 1;
	        	if(temp >= 0) break;
	        	count = count << 1;
	        }
        
        }
        
        if(sign && res == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(sign) return res;
        return -res;
    }
    public static void main(String[] args) {
		System.out.println(divide(-2147483648,-2147483648));
	}
}

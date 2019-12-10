package test70_79;

public class Test70 {
	/** 斐波那契数列 - 动态规划 **/
    public static int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int a = 1;
        int b = 2;
        for(int i = 0; i < n - 2; i++) {
        	int temp = a+b;
        	a = b;
        	b = temp;
        }
        return b;
    }
    
    public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}
}

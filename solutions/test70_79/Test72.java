package test70_79;
/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
动态规划：
dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数

所以，

当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；

当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。

 * @author WOQUQ
 *
 */
public class Test72 {
    public static int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        
        int[] dp = new int[size2+1];
        for(int i = 0; i < size2+1; i++) dp[i] = i;
        
        for(int i = 0; i < size1; i++) {
        	int temp = i;
        	dp[0] = i+1;
        	for(int j = 0; j < size2; j++) {
        		if(word1.charAt(i) == word2.charAt(j)) {
        			int test = dp[j+1];
        			dp[j+1] = temp;
        			temp = test;
        		}
        		else {
        			int test = dp[j+1];
        			dp[j+1] = Math.min(temp, Math.min(dp[j+1], dp[j])) + 1;
        			temp = test;
        		}
        	}
        }
        return dp[size2];
    }
    public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}
}

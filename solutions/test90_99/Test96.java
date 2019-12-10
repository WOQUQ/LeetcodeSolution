package test90_99;
/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
 * @author WOQUQ
 *
 */
public class Test96 {
	public static int numTrees(int n) {
        //如检测到n为零，则直接返回0
		if(n == 0) {
			return 0;
		}
		
		//开始递归
		int ans = getTreesNum(1,n);
		return ans;
		
    }
	
	private static int getTreesNum(int begin,int end) {
		//如检测到begin >= end,返回1
		if(begin >= end) {
			return 1;
		}
		
		int ans = 0;
		//针对begin到end之间的所有可能划分左右子树
		for(int i = begin; i <= end; i++) {
			//得到可能的左子树数量
			int leftNum = getTreesNum(begin,i-1);
			
			//得到可能的右子树数量
			int rightNum = getTreesNum(i+1,end);
			
			//将左右子树可能性两两进行组合
			int temp = leftNum * rightNum;
			
			//将结果加入ans中
			ans += temp;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(numTrees(19));
	}
	
	/**为了以 3 为根从序列 [1, 2, 3, 4, 5, 6, 7] 构建二叉搜索树，我们需要从左子序列 [1, 2] 构建左子树，从右子序列 [4, 5, 6, 7] 构建右子树，然后将它们组合(即笛卡尔积)。
巧妙之处在于，我们可以将 [1,2] 构建不同左子树的数量表示为 G(2)G(2), 从 [4, 5, 6, 7]` 构建不同右子树的数量表示为 G(4)G(4)。这是由于 G(n)G(n) 和序列的内容无关，只和序列的长度有关
*/
	
//	public class Solution {
//		  public int numTrees(int n) {
//		    int[] G = new int[n + 1];
//		    G[0] = 1;
//		    G[1] = 1;
//
//		    for (int i = 2; i <= n; ++i) {
//		      for (int j = 1; j <= i; ++j) {
//		        G[i] += G[j - 1] * G[i - j];
//		      }
//		    }
//		    return G[n];
//		  }
//		}

}

package test10_19;
/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author WOQUQ
 *方法二：双指针法
算法

这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。

我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。

 */
public class Test11 {
    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int res = Math.min(height[begin], height[end])*end;
        int temp = 0;
        while(begin < end) {
        	if(height[begin] < height[end]) begin++;
        	else if(height[begin] > height[end]) end--;
        	else {
        		if(height[begin+1] < height[end-1]) end--;
        		else begin++;
        	}
        	temp = Math.min(height[begin], height[end])*(end - begin);
        	res = temp > res ? temp : res; 
        }
        return res;
    }
}

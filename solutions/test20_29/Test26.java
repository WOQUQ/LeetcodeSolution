package test20_29;
/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author WOQUQ
 *
 */
public class Test26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int m = 1;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[i-1]) {
        		nums[m] = nums[i];
        		m++;
        	}
        }
        return m;
    }
}

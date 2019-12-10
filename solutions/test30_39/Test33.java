package test30_39;
/**.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
 * @author WOQUQ
 *
 */
public class Test33 {
    public static int search(int[] nums, int target) {
        //find the position of the change
    	int change = findChangePoint(nums,0,nums.length-1);
    	
    	if(change == -1) {
    		return findTarget(nums,0,nums.length-1,target);
    	}else {
    		return nums[0] > target ? 
    				findTarget(nums,change+1,nums.length-1,target)
    				:findTarget(nums,0,change,target);
    	}
    	
    	
    }
    
    private static int findChangePoint(int[] nums, int begin, int end) {
    	if(begin <= end) {
    		int temp = begin + (end - begin) / 2 ;
    		if(temp < nums.length-1 && nums[temp] >nums[temp + 1]) {
    			return temp;
    		}else {
    			int left = findChangePoint(nums,begin,temp-1);
    			if(left != -1) return left;
    			int right = findChangePoint(nums,temp+1,end);
    			if(right != -1) return right;
    			return -1;
    		}
    	}else {
    		return -1;
    	}
    }
    private static int findTarget(int[] nums,int begin,int end,int target) {
    	if(begin <= end) {
    		int temp = begin + (end - begin) / 2 ;
    		if(nums[temp] == target) {
    			return temp;
    		}else {
    			int left = findTarget(nums,begin,temp-1,target);
    			if(left != -1) return left;
    			int right = findTarget(nums,temp+1,end,target);
    			if(right != -1) return right;
    			return -1;
    		}
    	}else {
    		return -1;
    	}
    }
    public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		System.out.println(search(nums,0));
	}
}

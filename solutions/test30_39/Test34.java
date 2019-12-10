package test30_39;
/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]
 * @author WOQUQ
 *
 */
public class Test34 {
	public  int[] searchRanger(int[] nums, int target) {
		int[] res = new int[2];
		if(nums.length == 0) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		res[0] = helper_first(nums,0,nums.length-1,target);
		res[1] = helper_last(nums,0,nums.length-1,target);
		return res;
	}
	
	private  int helper_first(int[] nums,int begin, int end, int target) {
		if(begin < 0 || begin >=nums.length || end < 0 || end >= nums.length || begin > end) return -1;
		int medium = begin + (end - begin)/2;
		if(nums[medium] == target && (medium == 0 || nums[medium-1] != target)) return medium;
		else if(nums[medium] == target) {
			int left = helper_first(nums,begin,medium-1,target);
			int right = helper_first(nums,medium+1,end,target);
			return left==-1 ? right : left;
		}
		if(begin == end) return -1;
		
		if(nums[medium] < target) return helper_first(nums,medium+1,end,target);
		else return helper_first(nums,begin,medium-1,target);
		
	}
	private int helper_last(int[] nums, int begin, int end, int target) {
		if(begin < 0 || begin >=nums.length || end < 0 || end >= nums.length || begin > end) return -1;
		int medium = begin+(end-begin)/2;
		if(nums[medium] == target && (medium == nums.length-1 || nums[medium+1] != target)) return medium;
		else if(nums[medium]==target) {
			int left = helper_last(nums,begin,medium-1,target);
			int right = helper_last(nums,medium+1,end,target);
			return left == -1 ? right : left;
		}
		if(begin == end) return -1;
		
		if(nums[medium] < target) return helper_last(nums,medium+1,end,target);
		else return helper_last(nums,begin,medium-1,target);
	}
	public static void main(String[] args) {
		Test34 test = new Test34();
		int[] nums = {3,3,3};
		int target = 3;
		System.out.println(test.searchRanger(nums, target)[0]);
		System.out.println(test.searchRanger(nums, target)[1]);
	}
}

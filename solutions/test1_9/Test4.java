package test1_9;
/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

 * @author WOQUQ
 * 基本思路（网上的）：两个有序数组求中位数，问题一般化为，求两个有序数组的第k个数，当k = (m+n)/2时为原问题的解。
怎么求第k个数？分别求出第一个和第二个数组的第 k / 2个数 a 和 b，然后比较 a 和 b，
当a < b ，说明第 k 个数位于 a数组的第 k / 2个数后半段，或者b数组的 第 k / 2 个数前半段，问题规模缩小了一半，然后递归处理就行

 */
public class Test4 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//首先判断两个数组的长度和是奇数还是偶数，以此判断是取一个数，还是取两个数
		//如果是奇数，则只需要取唯一中位数
		if( (nums1.length + nums2.length) % 2 == 1 ) {
			int medium = (nums1.length + nums2.length + 1)/2;//我们需要找到两个数组中第medium小的数
			return searchMedium(nums1,nums2,medium,0,0);
		}
		
		//如果是偶数，则需要取两个数然后取平均值
		else {
			int medium1 = (nums1.length + nums2.length)/2;
			int medium2 = (nums1.length + nums2.length)/2 + 1;
			
			return ( searchMedium(nums1,nums2,medium1,0,0)+searchMedium(nums1,nums2,medium2,0,0) )/2.0;
		}
    }
	private static double searchMedium(int[] nums1, int[] nums2, int medium, int start1, int start2) {
		//判断medium是否为1，若是，则返回两数组第一个数中较小的那一个
		if(medium == 1) {
			if(start1 > nums1.length-1) {
				return (double) nums2[start2];
			}else if(start2 > nums2.length-1) {
				return (double) nums1[start1];
			}
			return (double) Math.min(nums1[start1], nums2[start2]);
		}
		
		
		
		int half = medium/2 - 1;//数组下标-1
		
		//判断两个数组中下标为start的数是否存在（这一步主要针对两数组长度相差较悬殊的情况，较短的数组已经完全从查找范围中除去时）
		if(start1 > nums1.length-1 ) {
			//如果nums1越界，则直接返回nums2中下标half+start2的数
			return (double) nums2[medium+start2 - 1];
		}else if(start2 > nums2.length-1) {
			//同理，如果nums2越界，则直接返回nums1中下标为half+start1的数
			return (double) nums1[medium+start1 - 1];
		}
		
		
		//判断两个数组下标start+half 处的数
		int num1 = 0;//数组1的待比较数
		int num2 = 0;//数组2的待比较数
		int position1 = 0;//数组1待比较数的下标
		int position2 = 0;//数组2待比较数的下标
		
		//首先判断start+half是否越界（同时只可能有一个越界），
		if((start1 + half) > nums1.length-1 ) {
			//如果越界，则将越界数组的 待比较数 设为最后一个最大数
			position1 = nums1.length - 1;
			//另一个数组的 待比较数 设为下标为start+half的数
			position2 = start2 + half;
		}else if((start2 + half) > nums2.length-1 ) {
			position2 = nums2.length - 1;
			position1 = start1 + half;
		}
		//若两个数组均未越界，则均取下标为start+half处的数
		else {
			position1 = start1 + half;
			position2 = start2 + half;
		}
		num1 = nums1[position1];
		num2 = nums2[position2];
		
		//比较num1和num2，将较小的那一个从查找范围中除去
		if(num1 <= num2) {
			return searchMedium(nums1,nums2,medium - (position1 - start1 + 1),position1+1, start2);
		}else {
			return searchMedium(nums1,nums2,medium - (position2 - start2 + 1),start1, position2 + 1);
		}
		
	}
	public static void main(String[] args) {
		int[] nums1 = {3,3,3};
		int[] nums2 = {3,4,5,6,7,8,9};
		System.out.println(findMedianSortedArrays( nums1,nums2));
	}
}

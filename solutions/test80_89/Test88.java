package test80_89;

public class Test88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        for(int  i = m+n-1; i>=0; i--){
            if(index1 == -1 || index2 == -1){
                if(index1 == -1){
                    for(int j = i; j >= 0; j--){
                        nums1[j] = nums2[j];
                    }
                }
                break;
            }

            if(nums1[index1] > nums2[index2]){
                nums1[i] = nums1[index1];
                index1--;
            }else{
                nums1[i] = nums2[index2];
                index2--;
            }
        }

        for(int num : nums1){
            System.out.println(num);;
        }
    }

    // Test
    public static void main(String[] args) {
        Test88 test = new Test88();
        int[] nums1 = {0};
        int[] nums2 = {1};
        test.merge(nums1, 0, nums2, 1);
        // System.out.println(nums1.toString());

    }
}
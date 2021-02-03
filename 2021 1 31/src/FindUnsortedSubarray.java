import java.util.Arrays;

public class FindUnsortedSubarray {
    //给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //请你找出符合题意的 最短 子数组，并输出它的长度。
    public static int findUnsortedSubarray(int[] nums) {
        int[] arr = new int[nums.length];
        //将nums复制给arr
        System.arraycopy(nums, 0, arr, 0, nums.length);
        //对nums排序
        Arrays.sort(nums);
        int start = 0, end = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (arr[i] != nums[i]) {//找到最左边需要排序的数的位置
                start = i;
                break;
            }
        }
        if (i >= nums.length) {//不需要排序的情况
            return 0;
        }
        for (i = nums.length - 1; i >= 0; i--) {
            if (arr[i] != nums[i]) {//找到最右边需要排序的数的位置
                end = i;
                break;
            }
        }
        //求出两个位置之间的数的个数，即为合题意的最短子数组的长度
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
        int[] nums1 = {1,2,3,4};
        System.out.println(findUnsortedSubarray(nums1));
        int[] nums2 = {4,3,2,1};
        System.out.println(findUnsortedSubarray(nums2));
    }
}

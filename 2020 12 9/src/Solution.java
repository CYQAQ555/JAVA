import java.util.Arrays;
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null) {
            return null;
        }//判空
        int left = 0, right = nums.length - 1;//双指针法
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{nums[left], nums[right]};
            else if (sum > target)
                right--;
            else
                left++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] arr = twoSum(nums,target);
        System.out.println(Arrays.toString(arr));
    }
}

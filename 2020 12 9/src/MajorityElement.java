import java.util.Arrays;
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i <= len/2;i++) {
            int j = i + len/2;
            if(nums[i] == nums[j]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9,5,9,5,5,5};
        System.out.println(majorityElement(nums));
    }
}

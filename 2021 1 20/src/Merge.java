import java.util.Arrays;
public class Merge {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;  //最后一个位置
        int i = m - 1, j = n - 1;
        //每次都挑最大的数出来
        while(i >= 0 && j >= 0){
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int m = nums1.length;
        int[] nums2 = {2,5,6};
        int n = nums2.length;
        System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
    }
}

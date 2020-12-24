public class RemoveDuplicates {//移除数组中相同元素，并返回数组长度
    public static int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums != null ? nums.length : 0;
        }
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){//遇到相同数字则将它移出数组（跳过这个数，不将其计入数组长度）
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}

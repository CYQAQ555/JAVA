import java.util.Arrays;
public class Transform {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(transform(a)));
    }
    public static int[] transform(int[] a){
        int left = 0;
        int right = a.length - 1;
        while(left < right){
            while(left < right && a[left] % 2==0){//判断左边是否为偶数
                left++;
            }
            while(left < right && a[right] % 2 != 0){//判断右边是否为奇数
                right--;
            }
            //将奇数换在数组后面
            int t = a[right];
            a[right] = a[left];
            a[left] = t;
        }
        return a;
    }
}

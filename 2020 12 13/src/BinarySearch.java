import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println("所找的数在数组中下标值为：" + bin(arr,1));
    }
    public static int bin(int[] arr,int dest) {
        int ret=0;
        Arrays.sort(arr);
        int left = 0,right = arr.length-1;//二分法
        while(left <= right) {               //注意left==right的情况
            int mid = (left + right) / 2;      //mid要在循环内定义
            if(arr[mid] > dest) {
                right = mid - 1;
            }
            else if(arr[mid] < dest) {
                left = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

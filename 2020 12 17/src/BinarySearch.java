import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的数:");
        int key = sc.nextInt();
        if (binarySearch(arr, key)) {
            System.out.println("找到了");
        } else {
            System.out.println("没找到");
        }
    }

    public static boolean binarySearch(int[] arr,int key) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(key < arr[mid]) {
                right = mid - 1;
            }else if(key > arr[mid]) {
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}

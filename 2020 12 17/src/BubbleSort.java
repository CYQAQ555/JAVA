import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,7,54,1,55,14};
        System.out.println("数组原来为: " + Arrays.toString(arr));
        int[] arr1 = bubbleSort(arr);
        System.out.println("数组排序后: " + Arrays.toString(arr1));
    }
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}

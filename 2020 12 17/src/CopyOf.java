import java.util.Arrays;

public class CopyOf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr1 = copyOf(arr);
        System.out.println("复制后数组为: " + Arrays.toString(arr1));
    }
    public static int[] copyOf(int[] arr) {
        int[] arr1 = new int[arr.length];
        int i = 0;
        while (i < arr.length) {
            arr1[i] = arr[i];
            i++;
        }
        return arr1;
    }
}

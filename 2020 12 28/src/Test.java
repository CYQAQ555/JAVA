import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class Test {
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        int tmp = 0;
        for (int j = len; j >= 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println("sort over");
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,1,4,1,24,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

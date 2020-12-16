import java.util.Arrays;

public class TwoDimensionalArray {
    /*二维数组排序
    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{4,5,6}};
        int[][] arr2 = new int[2][3];
        int[][] arr3 = new int[2][];
        int[][] arr4 = new int[][]{{1,2,3},{4,5,6}};
        //方法1
        for(int i = 0;i <arr1.length;i++) {
            for(int j = 0;j < arr1[i].length;j++) {
                System.out.print(arr1[i][j] + " ");
            }
        }
        System.out.println();
        //方法2
        for (int[] arr : arr1) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
        //方法3
        String ret = Arrays.deepToString(arr1);
        System.out.println(ret);
    }*/
    //不规则二维数组
    public static void main(String[] args) {
        int[][] arr = new int[2][];
        arr[0] = new int[4];
        arr[1] = new int[5];
        String ret = Arrays.deepToString(arr);
        System.out.println(ret);
    }
}

public class ShuZuNiXu {
    public static void main(String[] args) {
        //数组的逆序 {12，69，852，25，89，588}
        int[] arr = {588,89,25,852,69,12};
        reverse(arr);
        printArray(arr);
    }
    public static void reverse(int[] arr) {
        for(int min = 0,max = arr.length - 1;min < max; min++,max--) {
            //对数组的元素进行位置交换
            int temp=arr[min]; //定义了一个什么都没有的变量 保存下标为min的元素 然后min就空了
            arr[min]=arr[max];
            arr[max]=temp;
        }
    }
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}

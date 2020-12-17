public class ToString {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println("数组转字符串为: " + toString(arr));
    }
    public static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length - 1) {
                ret += arr[i] + ",";
            }else if(i == arr.length - 1) {
                ret += arr[i] + "]";
            }
        }
        return ret;
    }
}

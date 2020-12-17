public class WellAligned {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(aligned(arr));
        int[] arr1 = {1,3,6,4,5,8};
        System.out.println(aligned(arr1));
    }
    public static boolean aligned(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

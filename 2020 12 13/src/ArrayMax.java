public class ArrayMax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9,6,7,8,9};
        int max = arrayMax(arr);
        System.out.println("max = " + max);
    }
    public static int arrayMax(int[] arr) {
        if(arr == null) {
            return  0;
        }
        int t = 0;
        int left = 0, right = arr.length - 1;
        while(arr[left] <= arr[right]) {
            if(t < arr[right]){
                t = arr[right];
            }
            left++;
            right--;
        }
        return t;
    }
}

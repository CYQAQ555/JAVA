import java.util.Arrays;
public class Swap {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] b = {9,8,7,6,5,4};
        swap(a,b);
    }
    public static void swap(int[] a,int[] b) {
        if(a.length == b.length){
            for (int i = 0; i < a.length; i++) {
                int t = a[i];
                a[i] = b[i];
                b[i] = t;
            }
        }
        System.out.println("a:"+Arrays.toString(a));
        System.out.println("b:"+Arrays.toString(b));
    }
}

public class ArrayAverage {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,88,7};
        System.out.println(avg(arr));
    }
    public static double avg(int[] arr){
        double t = 0.0;
        for(int x:arr){
            t += x;//数组中所有元素和
        }
        return t / arr.length;
    }
}

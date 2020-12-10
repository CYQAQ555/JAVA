public class SUM {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        System.out.println("sum = " + sum(arr));
    }
    public static int sum(int[] arr){
        int sum = 0;
        for(int x:arr){
            sum += x;//数组中所有元素和
        }
        return sum;
    }
}

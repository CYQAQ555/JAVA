//实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型)
public class AVG {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(avg(arr));
    }
    public static double avg(int[] a){
        int t = 0;
        double sum;
        for(int x:a){
            t += x;//数组中所有元素和
        }
        sum = t / a.length;//平均值
        return sum;
    }
}

public class MAX {
        public static void main(String[] args) {
            int a=2020;
            int b=12;
            double c=9.0;
            double d=13.5;
            System.out.println("两个整数中最大的数为:");
            System.out.println(Max(a,b));
            System.out.println("两个小数中最大的数为:");
            System.out.println(Max(c,d));
            System.out.println("两个小数和一个整数的大小关系:");
            Max(a,c,d);
        }
        public  static int Max(int a,int b) {
            int max1 = a > b ? a : b;
            return max1;
        }
        public static double Max(double c,double d) {
            double max2 = c > d ? c : d;
            return max2;
        }
        public static void Max(int a,double c,double d) {
            double t = c > d ? c : d;//求小数中较大的
            double max = t > a ? t : a;//求最大值；
            double t1 = c < d ? c : d;//求小数中较小的；
            double min = t1 < a ? t1 : a;//求最小值
            double mid = (c + d + a) - max - min;//求中间值
            System.out.print(max + ">" + mid + ">" + min);//输出大小关系
        }
}

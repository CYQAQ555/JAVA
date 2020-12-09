public class ADD {
    public static void main(String[] args) {
        int a = 2020;
        int b = 12;
        double c = 9.0;
        double d = 13.5;
        double e = 14.9;
        System.out.println("两个整数和为:");
        System.out.println(Add(a,b));
        System.out.println("三个小数和为:");
        System.out.println(Add(c,d,e));
    }
    public  static int Add(int a,int b) {
        return  a + b;
    }
    public static double Add(double c,double d,double e) {
        return c + d + e;
    }
}

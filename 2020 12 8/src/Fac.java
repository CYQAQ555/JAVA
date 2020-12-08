import java.util.Scanner;
public class Fac {
    public static int Fac(int n) {
        int t = 1;
        for (int i = 1; i <= n; i++) {
            t *= i;
        }
        return t;
    }
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("这个数的阶乘为：");
        System.out.println(Fac(n));
    }
}

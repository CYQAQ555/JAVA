import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入N:");
        int n = sc.nextInt();
        System.out.println("其阶乘为:");
        System.out.println(fac(n));
    }
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}

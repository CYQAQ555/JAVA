import java.util.Scanner;
public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要求第几项：");
        int n = sc.nextInt();
        System.out.println("该项为：");
        System.out.println(fib(n));
    }
    public static int fib(int n ) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

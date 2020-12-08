import java.util.Scanner;
public class Fibonacci {
    public static int Fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return Fib(n-1)+Fib(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入斐波那契数列第几项：");
        int n = sc.nextInt();
        System.out.println(Fib(n));
    }
}

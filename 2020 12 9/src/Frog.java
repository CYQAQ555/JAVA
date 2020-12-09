//一只青蛙一次可以跳上一个台阶，也可以跳上两个，求该青蛙跳上一个n级台阶总共有多少种跳法？
import java.util.Scanner;
public class Frog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入青蛙跳的台阶数：");
        int n = sc.nextInt();
        System.out.println("一共有" + fib(n) + "种方法");
    }
    public static int fib(int x){
        if(x == 1) {
            return 1;
        }else if(x == 2) {
            return 2;
        }else{
            return fib(x-1)+fib(x-2);
        }
    }
}

import java.util.Scanner;
public class SUM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int n = sc.nextInt();
        System.out.println("其数字之和为:");
        System.out.println(sum(n));
    }
    public static int sum(int n) {
        if(n < 10){
            return n;
        }
        return n % 10 + sum(n / 10);
    }
}

import java.util.Scanner;
public class Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int n = sc.nextInt();
        System.out.println("其每一位为:");
        print(n);
    }
    public static void print(int n) {
        if(n > 9) {
            print(n / 10);
        }
        System.out.print(n % 10 + " ");
    }
}

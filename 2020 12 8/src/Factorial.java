import java.util.Scanner;
public class Factorial {
    public static int Fac(int n){
        int sum = 0;
        for (int i = 1;i <= n;i++){
            int t = 1;
            for(int j = 1;j <= i;j++){
                t *= j;
            }
            sum += t;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("这个数的阶乘和为：");
        System.out.println(Fac(n));
    }
}

/*
  整数反转
  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
import java.util.Scanner;

public class ZhengShuFanZhuan {
    public static  int reverse(int x) {
        int res = 0;
        while (x != 0) {//不为零的情况下
            int tmp = res;//存储之前计算的结果
            res = res * 10 + x % 10;//取最后一位的数，将其进位
            x /= 10;//去掉最后一位的数
            if (res / 10 != tmp)//将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
                return 0;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverse(n));
    }
}

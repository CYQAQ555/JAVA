import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();//输入一个数
            int i = 2;
            for (; i <= Math.sqrt(x); i++) {
                if (x % i == 0)//判断是否可以被其他数整除
                {
                    System.out.println(x + "不是素数");
                    break;
                }
            }
            if (i > Math.sqrt(x)) {
                System.out.println(x + "是素数");
            }
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();//输入一个数
        boolean flag = true;
        if (x == 1)//1不是素数
        {
            flag = false;
        }
        for(int i = 2;i < x; i++)
        {
            if(x%i == 0)//判断是否可以被其他数整除
            {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            System.out.println(x + "是素数");
        }
        else
        {
            System.out.println(x + "不是素数");
        }
    }
    public static void main1(String[] args) {
        boolean flag;
        for(int i = 2;i <= 100;i++)
        {
            flag = true;
            for(int j = 2;j <= 100;j++)
            {
                if(i != j && i%j == 0)//若能被自身以外的数整除
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println(i);
            }
        }
    }
}

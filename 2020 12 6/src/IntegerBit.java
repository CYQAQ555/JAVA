import java.util.Scanner;
public class IntegerBit {
    public static void printf(int n) {
        if(n > 9){
            printf(n/10);
        }
        System.out.println(n%10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = sc.nextInt();
        System.out.println("其每一位是：");
        printf(n);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = sc.nextInt();
        int num = 0;
        System.out.println("其每一位是：");
        while (n != 0){
            num = n % 10; //获取每一位
            n = n / 10;	//整数退一位
            System.out.print(num+" ");
        }
    }
}

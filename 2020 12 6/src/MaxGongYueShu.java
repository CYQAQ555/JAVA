import java.util.Scanner;
public class MaxGongYueShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int n1 = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int n2 = sc.nextInt();
        int max = 0;
        if(n1 != n2){
            while(n1 % n2 != 0) {
                max = n1 % n2;
                n1 = n2;
                n2 = max;
            }
            System.out.println("最大公约数为" + max);
        } else {
            System.out.println("最大公约数为" + n1);
        }
    }
}

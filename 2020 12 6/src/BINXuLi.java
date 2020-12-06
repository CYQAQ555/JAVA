import java.util.Scanner;
public class BINXuLi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字：");
        int n = sc.nextInt();
        System.out.println("偶数序列：");
        for(int i = 1;i < 32;i += 2){
            System.out.print((n >> i) & 1);
        }
        System.out.println("");
        System.out.println("奇数序列：");
        for(int i = 0;i < 31;i += 2){
            System.out.print((n >> i) & 1);
        }
    }
}

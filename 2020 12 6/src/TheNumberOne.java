import java.util.Scanner;
public class TheNumberOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        int count = 0;
        for(int i = 0;i < 32;i++){
            if(((n >> i) & 1) == 1){
                count++;
            }
        }
        System.out.println("其二进制中1的个数为："+count);
    }
}

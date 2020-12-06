import java.util.Random;
import  java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guess = random.nextInt(100)+1;
        while(true){
            System.out.println("请输入数字：（1-100）");
            int n = sc.nextInt();
            if(n < guess){
                System.out.println("低了");
            }else if(n > guess){
                System.out.println("高了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
        sc.close();
    }
}

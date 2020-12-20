import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int mid = 0,y = 0;
        int tmp = x;
        while(tmp != 0){
            mid = tmp % 10;
            y = y * 10 + mid;
            tmp = tmp / 10;
        }
        return y == x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));
    }

}

import java.util.Scanner;
class Exchange{
    public int n1;
    public int n2;
    public void exc(){
        int t = n2;
        n2 = n1;
        n1 = t;
        System.out.println("交换后为:");
        System.out.println("n1=" + n1 + " n2=" + n2);
    }
}
public class Exercise {
    public static void main(String[] args) {
        Exchange e = new Exchange();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要交换的数");
        e.n1 = sc.nextInt();
        e.n2 = sc.nextInt();
        e.exc();
    }
}

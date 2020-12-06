
public class ShuiXianHua {
    public static void main(String[] args) {
        for(int i = 100;i < 1000;i++) {
            int a = i / 100;//存放百位数
            int b = i / 10 % 10;//存放十位数
            int c = i % 10;//存放个位数
            if (a * a * a + b * b * b + c * c * c == 100 * a + 10 * b + c) {
                System.out.println(i);
            }
        }
    }
}

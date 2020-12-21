import java.util.Scanner;

public class RomanToInt {
    public static int romanToInt(String s) {
        int n = s.length();
        int x = 0;
        for(int i = 0;i < n;i++) {//遍历输入的罗马数字
            switch(s.charAt(i)) {//用charAt()方法返回指定索引处(s中第i位)的字符
                case 'I' :
                    x = x + 1;
                    break;
                case 'V' :
                    x = x + 5;
                    break;
                case 'X' :
                    x = x + 10;
                    break;
                case 'L' :
                    x = x + 50;
                    break;
                case 'C' :
                    x = x + 100;
                    break;
                case 'D' :
                    x = x + 500;
                    break;
                case 'M' :
                    x = x + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }
            if(i!=0) {
                if((s.charAt(i - 1)=='I')&&((s.charAt(i)=='X')||(s.charAt(i)=='V')))//4和9为右数减左数
                    x = x - 2;
                if((s.charAt(i - 1)=='X')&&((s.charAt(i)=='C')||(s.charAt(i)=='L')))//40和90
                    x = x - 20;
                if((s.charAt(i - 1)=='C')&&((s.charAt(i)=='D')||(s.charAt(i)=='M')))//400和900
                    x = x - 200;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(romanToInt(s));
    }
}

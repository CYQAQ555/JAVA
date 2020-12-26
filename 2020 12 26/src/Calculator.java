import java.util.Scanner;
public class Calculator {
    public double num1;
    public double num2;

    public void add(){
        System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
    }
    public void sub(){
        System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
    }
    public void mul(){
        System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
    }
    public void div(){
        System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数字:");
        calculator.num1 = sc.nextDouble();//初始化
        calculator.num2 = sc.nextDouble();

        System.out.println("请输入操作:1(+) 2(-) 3(*) 4(/)");
        Scanner sc1 = new Scanner(System.in);
        int num=sc1.nextInt();
        switch(num){
            case 1:
                calculator.add();
                break;
            case 2:
                calculator.sub();
                break;
            case 3:
                calculator.mul();
                break;
            case 4:
                calculator.div();
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }
}

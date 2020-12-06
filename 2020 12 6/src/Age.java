import java.util.Scanner;
public class Age {
    public static void main(String[] args) {
        System.out.println("请输入年龄：");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(0 <= age && age <= 18)
        {
            System.out.println(age + "是少年");
        }
        else if(19 <= age && age <= 28)
        {
            System.out.println(age + "是青年");
        }
        else if(29 <= age && age <= 55)
        {
            System.out.println(age + "是青年");
        }
        else if(56 <= age && age <= 200)
        {
            System.out.println(age + "是老年");
        }
        else
        {
            System.out.println(age + "震惊");
        }
    }
}

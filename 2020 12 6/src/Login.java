import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 3;
        while(count != 0){
            String str = sc.nextLine();
            if(str.equals("123456")){
                System.out.println("登录成功");
                break;
            }else {
                count--;
                if(count != 0){
                    System.out.println("请重输：");
                }else{
                    System.out.println("退出程序");
                }
            }
        }
    }
}

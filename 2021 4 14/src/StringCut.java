
import java.util.Scanner;

public class StringCut {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String num1 = scanner.nextLine();
            String num2 = scanner.nextLine();

            num1 = num1.replace("", "-"); //每个字符加个-
            String[] first = num1.split("-");
            num2 = num2.replace("", "-"); //每个字符加个-
            String[] second = num2.split("-");

            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if(first[i].equals(second[j])){
                        num1 = num1.replace(first[i], "");//删除出现相同的字符
                    }
                }
            }
            System.out.println(num1.replace("-", "" ));
        }
    }

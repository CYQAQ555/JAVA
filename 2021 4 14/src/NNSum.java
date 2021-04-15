import java.util.Arrays;
import java.util.Scanner;

public class NNSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[3*n];
            for(int i = 0;i < 3 * n;i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for(int i = n;i <= (3*n)-1;i += 2) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }
}

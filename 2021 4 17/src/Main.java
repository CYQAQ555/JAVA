
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

    public class Main {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                Set<Integer> set = new HashSet<>();
                int n = scan.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scan.nextInt();
                    if (!set.contains(arr[i])) {//若未出现则加入集合
                        set.add(arr[i]);
                    } else {//删除重复出现的数
                        set.remove(arr[i]);
                    }
                }
                int[] res = new int[2];//只有两个数出现了奇数次
                int k = 0;
                for (int i = 0; i < n; i++) {
                    if (set.contains(arr[i])) {
                        set.remove(arr[i]);
                        res[k++] = arr[i];//将这两个数放入res
                        //放满则结束
                        if (k == 2) {
                            //排序
                            if (res[0] < res[1]) {
                                System.out.println(res[0] + " " + res[1]);
                            } else {
                                System.out.println(res[1] + " " + res[0]);
                            }
                        }
                    }
                }
            }
        }
    }

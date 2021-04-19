import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
       // Scanner scan = new Scanner(System.in);
      //  while (scan.hasNext()) {
            //输入n
           // int n = scan.nextInt();
        int n = 7;
           // int[] arr = new int[n];
        int[] arr = {3,4,1,5,6,2,7};
            //输入数组
//            for (int i = 0; i < n; i++) {
//                arr[i] = scan.nextInt();
//            }
            //用栈处理
            Stack<Integer> stack = new Stack<>();
            Point[] res = new Point[arr.length];//可以不用建立二维数组
            for(int i = 0; i < arr.length; i++) {
                if(!stack.isEmpty() && arr[stack.lastElement()] > arr[i]) {
                    int index;
                    while(!stack.isEmpty() && arr[index = stack.lastElement()] > arr[i]) {
                        //若此数不存在则为-1，若存在则是堆栈中最后一个元素
                        res[index] = new Point(stack.isEmpty() ? - 1 : stack.lastElement(),i);
                        stack.pop();//返回栈顶元素且且把它删除
                    }
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int index = stack.pop();
                res[index] = new Point(stack.isEmpty() ? - 1 : stack.lastElement(),-1);
            }
            for (Point re : res) {
                System.out.println(re.x + " " + re.y);
            }
       // }
    }
        public static class Point {//用一个类解决两个数的输出问题
            public int x;
            public int y;
            public Point(int x,int y) {
                this.x = x;
                this.y = y;
            }
        }

}

import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            //输入n
            int n = scan.nextInt();
            int[] arr = new int[n];
            //输入数组
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            //用栈处理
            Stack<Integer> stack = new Stack<Integer>();
            Point[] res = new Point[arr.length];//
            for(int i = 0; i < arr.length; i++) {
                if(!stack.isEmpty() && arr[stack.lastElement()] > arr[i]) {
                    int index;
                    while(!stack.isEmpty() && arr[index = stack.lastElement()] > arr[i]) {
                        res[index] = new Point(stack.isEmpty() ? - 1 : stack.lastElement(),i);
                        stack.pop();
                    }
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int index = stack.pop();
                res[index] = new Point(stack.isEmpty() ? - 1 : stack.lastElement(),-1);
            }
            for(int i = 0;i <res.length; i++) {
                System.out.println(res[i].x + "," + res[i].y);
            }
        }
    }
        public static class Point {
            public int x;
            public int y;
            public Point(int x,int y) {
                this.x = x;
                this.y = y;
            }
        }

}

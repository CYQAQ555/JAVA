public class HasStatic {//1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
        HasStatic hsl = new HasStatic();// 4
        x++;// 5
        HasStatic hs2 = new HasStatic();// 6
        x++;// 7
        hsl = new HasStatic();// 8
        x++;// 9
        HasStatic.x--;// 10
        System.out.println(" x=" + x);// 11
    }
}

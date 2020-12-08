public class Array {
    public static int find(int[] array){
        int t = 0;
        for (int x : array) {
            t = t ^ x;//两个相同的数异或结果为0，不为0的数和0异或结果为本身
        }
        return t;
    }
    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,3,4,4,5};
        System.out.println(find(array));
    }
}

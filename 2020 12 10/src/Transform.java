public class Transform {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println("修改后数组为：");
        transform(arr);
    }

   public static void transform(int[] arr) {
       System.out.print("{");
       for(int x : arr) {
           System.out.print(x*2 + ",");
        }
       System.out.print("}");
   }
}

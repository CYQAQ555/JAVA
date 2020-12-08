public class Odd {
    public static void Odd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] % 2 != 0){//把奇数换在前面
                    int tmp=array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
            }
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Odd(array);
    }
}

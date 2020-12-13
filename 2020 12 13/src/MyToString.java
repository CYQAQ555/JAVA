public class MyToString {
    public static String myToString(int[] array) {
        if(array == null) {
            return "null";
        }
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret = ret + array[i];
            if(i != array.length - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        String arr = myToString(array);
        System.out.println(arr);
    }
}

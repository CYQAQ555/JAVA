public class StrStr {
    public static int strStr(String haystack, String needle) {
        int length = needle.length();
        int index = 0;
        while (index + length <= haystack.length()){
            if (needle.equals(haystack.substring(index,index+length))){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String  haystack = "hello";
        String  needle = "ll";
        System.out.println(strStr(haystack,needle));
    }
}

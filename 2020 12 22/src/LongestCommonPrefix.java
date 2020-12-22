//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs.length; i++) {//遍历字符串数组
            if (!strs[i].startsWith(s)) {//startsWith()方法是一个String类方法，用于检查给定的字符串是否以特定的字符序列开头。
                s = s.substring(0, s.length() - 1);//substring截取字符串从第零位开始到字符串对象长度减一位
                // 在java中String类可以定义字符串变量和字符串数组，length()用于求String字符串对象的长度，而length用于求String字符串数组的长度。
                //当字符串无公共前缀时，s会减为空返回
                i--;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        //String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}

public class ToLowerCase {
    public static String toLowerCase(String str) {
        StringBuilder str1 = new StringBuilder();//StringBuilder类代表可变字符串对象,字符序列可变,没有重新生成一个对象，而且在原来的对象中可以连接新的字符串
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);//charAt()方法用于返回指定索引处的字符,索引范围为从0到length()-1;
            if (c >= 65 && c <= 90) {
                c += 32;
            }
            str1.append(c);//把任何类型数据的字符串表示连接到调用的stringbilder对象的末尾
        }
        return str1.toString();
    }

    public static void main(String[] args) {
        String str = "Hello";
        String str1 = toLowerCase(str);
        System.out.println(str1);
    }
}

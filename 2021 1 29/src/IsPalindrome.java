public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if(s == null) {//空字符串定义为有效的回文串
            return true;
        }
        s = s.toLowerCase();//将字符串全部转换成小写
        int len = s.length();
        StringBuilder str = new StringBuilder(len);
        for (char c : s.toCharArray()) {//遍历字符串
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {//去掉符号只考虑字母和数字字符
                str.append(c);
            }
        }
        String s1 = new StringBuilder(str).reverse().toString();//反转字符串
        return str.toString().equals(s1);
        //return str.toString().equals(str.reverse().toString());
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}

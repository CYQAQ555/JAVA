public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {//从字符串末尾开始寻找
            if (s.charAt(i) != ' ') {//找到最后一个单词计算其长度
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }

    public static void main1(String[] args) {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }
}

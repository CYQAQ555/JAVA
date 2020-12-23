public class IsValid1 {
        public static boolean isValid(String s) {
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                //replace() 方法通过用 newChar"" 字符替换字符串中出现的所有 searchChar"()/{}/[]" 字符，并返回替换后的新字符串。
                s = s.replace("()", "");
                s = s.replace("{}", "");
                s = s.replace("[]", "");
            }
            return s.length() == 0;//若所有括号能被替换完即长度为0
        }

        public static void main(String[] args) {
            String s = "([{}])";
            System.out.println(isValid(s));
        }
}

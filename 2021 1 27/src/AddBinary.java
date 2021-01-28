public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int c = 0;//进位
        int i = a.length()-1, j = b.length()-1;
        while(i >= 0 || j >= 0 || c != 0){
            if(i >= 0) {
                c += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                c += b.charAt(j--) - '0';
            }
            s.append(c % 2);
            c /= 2;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a,b);
        System.out.println(s);
    }
}

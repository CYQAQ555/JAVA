public class Nine {
    public static void main(String[] args) {
        int count = 0;//记录9的个数
        for(int i = 1;i <= 100;i++)
        {
            if(i%10 == 9)//判断个位是9的数
            {
                count++;
            }
            if(i/10 == 9)//判断十位是9的数
            {
                count++;
            }
        }
        System.out.println(count);
    }
}

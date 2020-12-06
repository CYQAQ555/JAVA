//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
public class FenShuZhi {
    public static void main(String[] args) {
        double sum1 = 0;
        double sum2 = 0;
        for(double i = 1;i <= 99;i=i+2){//1/1+1/3+1/5 …… +1/99
            sum1 += 1/i;
        }
        for(double j = 2;j <= 100;j=j+2){//1/2+1/4 …… +1/100
            sum2 += 1/j;
        }
        System.out.println(sum1-sum2);
    }
}

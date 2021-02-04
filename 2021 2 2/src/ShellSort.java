public class ShellSort {
    public static void main(String [] args)
    {
        int[]a={10,20,8,25,35,6,18,30,5,15,28};
        System.out.println("排序之前：");
        for(int i = 0;i < a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
        //希尔排序
        int d = a.length;
        while(true){
            for(int i = 0;i < d;i++){
                for(int j = i;j + d < a.length;j += d){
                    int temp;
                    if(a[j] > a[j + d]){
                        temp = a[j];
                        a[j] = a[j+d];
                        a[j+d] = temp;
                    }
                }
            }
            if(d == 1) {
                break;
            }
            d--;
        }
        System.out.println();
        System.out.println("排序之后：");
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

}

public class Test {

    public String toString() {

        System.out.print("aaa");

        return "bbb";

    }

    public static void main(String[] args) {

        System.out.println(new Test());
    }

    /*static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args){
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };*/
   /* private float f = 1.0f;

    int m = 12;

    static int n = 1;

    public static void main(String args[]) {

        Test t = new Test();
        System.out.println(t.f);//private修饰，类的调用者不能直接使用
        System.out.println(t.m);
        System.out.println(Test.n);
    }*/
    /*public static int i ;
    public static int aMethod(){
        i++;
        return i;*/
    /*public static void main(String[] args){

        String s = null;

        System.out.println("s="+ s );

    }*/
}
/*public static void main(String args[]){
        //Test test = new Test();
        Test.aMethod();
        int j = Test.aMethod();
        System.out.println(j);
}*/

public class Test {
    private float f = 1.0f;
    int m = 12;
    static int n = 1;
    public static void main2 (String args[]) {
        Test t = new Test();
        int a = Test.n;
        float b = t.f;
        //float c = Test.f;错误
    }
}

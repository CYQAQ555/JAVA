class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
public class Test3 {
    public static void main(String[] args) {
        //Integer使用
        A<Integer> p = new A<>(100);
        System.out.println(p.get());
        //Float使用
        A<Float> pp = new A<>(100.1f);
        System.out.println(pp.get());
        //String使用
        A<String> ppp = new A<>("100");
        System.out.println(ppp.get());
    }
}

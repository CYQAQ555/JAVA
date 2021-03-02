public class Test {

    public static void printAll(MyArrayList<? extends Number> list) {

    }
    public static class MyArrayList<E>{

    }

    public static void main(String[] args) {
        printAll(new MyArrayList<Integer>());
        printAll(new MyArrayList<Double>());
        printAll(new MyArrayList<Number>());
        //printAll(new MyArrayList<Object>());
    }
}

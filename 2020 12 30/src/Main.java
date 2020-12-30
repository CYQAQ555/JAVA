public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add2(4);
        myArrayList.add2(5);
        System.out.println(myArrayList.contains(5));//true
        System.out.println(myArrayList.search(4));//3
        System.out.println(myArrayList.getPos(1));//2
        myArrayList.display();//1 2 3 4 5
        myArrayList.setPos(0,111);
        myArrayList.remove(2);
        System.out.println(myArrayList.size());//4
        myArrayList.display();//111 3 4 5
        myArrayList.clear();
        myArrayList.display();
    }
}

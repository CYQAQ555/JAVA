public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createdLinked();//12 22 32 42
        myLinkedList.addLast(100);//12 22 32 42 100
        myLinkedList.addFirst(1);//1 12 22 32 42 100
        myLinkedList.addIndex(0,110);//110 1 12 22 32 42 100
        myLinkedList.display();//110 1 12 22 32 42 100
        System.out.println("=================");
        System.out.println("链表长度为："+myLinkedList.size());//7
        System.out.println("=================");
        System.out.println("链表中是否有元素12："+myLinkedList.contains(12));//true
        System.out.println("=================");
        int n = 4;
        Node ret = myLinkedList.findN(n);
        System.out.println("链表第"+n+"个节点是："+ret.val);
        System.out.println("=================");
        System.out.println("421是否在链表中"+myLinkedList.contains(421));
        System.out.println("==================");
        ret = myLinkedList.findLastTwoNode();
        System.out.println(ret.val);
        System.out.println("虽然发生了异常，但是我还是想打印这句话");
        System.out.println("==================");
        myLinkedList.remove(1);
        myLinkedList.display();//110 12 22 32 42 100
        System.out.println("==================");
        Node ret1 = myLinkedList.reverseList();
        myLinkedList.display1(ret1);//100 42 32 22 12 110
        myLinkedList.clear();
    }
}

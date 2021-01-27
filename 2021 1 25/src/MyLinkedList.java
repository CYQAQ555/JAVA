import java.util.Iterator;
public class MyLinkedList<String> implements Iterable<String>{

    private int theSize;                          // 存储链表长度
    private int modCount = 0;                    // 记录链表被改变的次数
    private  Node<String> beginMaker;           // 头结点
    private Node<String> endMaker;             // 尾节点

    private static class Node<String>{
        public String data;                     // 存储Node节点数据
        public Node<String> prev;              // 前一节点的引用
        public Node<String> next;             // 后一节点的引用
        public Node( String d, Node<String> p, Node<String> n){
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {                    // MyLinkedList构造方法
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {                 // 头结点next域指向尾节点，尾节点prev域指向头节点
        beginMaker = new Node<String>(null, null, null);
        endMaker = new Node<String>(null, beginMaker, null);
        beginMaker.next = endMaker;
        theSize = 0;
        modCount++;
    }

    public int size() {                    // 返回链表的长度
        return theSize;
    }

    public boolean isEmpty() {            // 判断链表是否为空
        return size() == 0;
    }

    public boolean add(String x) {
        add(size(),x);
        return true;
    }

    public void add(int idx, String x) {
        addBefore(getNode(idx,0,size()),x);
    }

    private void addBefore(Node<String> p , String x) {
        Node<String> newNode = new Node<String>(x , p.prev , p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    public String set(int idx, String newVal) {
        Node<String> p = getNode(idx);
        String oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public String get(int idx) {
        return getNode(idx).data;
    }

    public Node<String> getNode(int idx){
        return getNode(idx,0,size()-1);
    }

    private Node<String> getNode(int idx, int lower, int upper){
        Node<String> p;
        if(idx < lower|| idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if(idx < size()/2) {
            p = beginMaker.next;
            for(int i = 0; i < idx; i++)
                p = p.next;
        }
        else {
            p = endMaker;
            for(int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p ;
    }

    public String remove(int idx) {
        return remove(getNode(idx));
    }

    public String remove(Node<String> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    public java.util.Iterator<String> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<String>{
        private Node<String> current = beginMaker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        public boolean hasNext() {
            return current!=endMaker;
        }
        public String next() {
            if(modCount!=expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            String nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }
        public void remove() {
            if(modCount!=expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }
}

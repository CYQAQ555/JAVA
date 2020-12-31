class   Node{
    public int val;
    public Node next;
    public Node(){
    }
    public Node(int val) {
        this.val = val;
    }
}
//无头单向非循环链表实现
public class MyLinkedList {
    public Node head;//表示当前链表的头，默认null
    //构建链表
    public void createdLinked() {
        this.head = new Node(12);
        Node node2 = new Node(22);
        Node node3 = new Node(32);
        Node node4 = new Node(42);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;
    }
    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //清空链表
    public void clear() {
        this.head = null;
    }
    //打印链表
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display1(Node node){
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    //找链表最后一个节点
    public Node findLastNode() {
        if(this.head == null) {
            System.out.println("head == null");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    //找链表倒数第二个节点
    public Node findLastTwoNode() {
        if(this.head == null) {
            System.out.println("head == null");
            return null;
        }
        if(this.head.next == null) {
            System.out.println("Only One Node");
            return null;
        }
        Node cur = this.head;
        while(cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    //找到第n个节点
    public Node findN(int n){
        if(this.head == null) {
            System.out.println("head == null");
            return null;
        }
        if(n <= 0) {
            System.out.println("太小");
            return null;
        }
        if(n > size()){
            System.out.println("太大");
            return null;
        }
        int count = 0;
        Node cur = this.head;
        while(count != n) {
            count++;
            cur = cur.next;
        }
        return cur;
    }
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else{
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //找到index-1位置的节点的引用
    public Node moveIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while(count != index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if(index < 0 || index > size()) {
            System.out.println("illegal");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        Node cur = moveIndex(index);//cur保存index - 1位置的节点的引用
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //查找key的前驱，如果有返回前驱节点的引用，没有返回null
    public Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null) {
            System.out.println("head == null");
        }
        if(this.head.val == key){
            this.head = this.head.next;
        }
        Node prev = searchPrev(key);
        if(prev == null) {
            System.out.println("error");
        }else{
            Node del = prev.next;
            prev.next = del.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllkey(int key) {
        if(this.head == null){
            System.out.println("head == null");
        }
        Node prev = this.head;
        Node cur = prev.next;
        while(cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
        }
    }
    //反转链表
    public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //返回链表的中间节点,如果有两个中间节点则返回第二个
    public Node middleNode1(){
        int len = size() / 2;
        Node cur = this.head;
        int count = 0;
        while (count != len) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

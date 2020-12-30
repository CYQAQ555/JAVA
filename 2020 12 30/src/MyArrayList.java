import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;
    public MyArrayList() {
        this.elem = new int[10];
    }
    public MyArrayList(int n) {
        this.elem = new int[n];
    }
    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    //判满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    //增加顺序表的长度
    public void resize() {
        this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        //返回一个数组，而这个数组就等于数组elem的前2elem.length个数,也就是elem[0] ~ elem[2elem.length - 1]
        //即将数组的大小扩展为原来的两倍
    }
    //在pos位置新增元素
    public void add(int pos,int data) {
        if(isFull()) {
            resize();
        }
        //判断pos是否合法
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("The location of the pos is illegal");
        }
        //移动元素
        for (int i = this.usedSize - 1; i >= pos ; i--) {
            this.elem[i + 1] = this.elem[i];//pos后的每一位都后移一位
        }
        this.elem[pos] = data;
        this.usedSize++;//新增一个元素后表长加一
    }
    //默认将元素插入到数组的最后
    public void add2(int data) {
        if(isFull()) {
            resize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("The location of the pos is illegal");
            return -1;
        }
        return this.elem[pos];
    }
    //给pos位置的元素设为value
    public void setPos(int pos,int value) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("The location of the pos is illegal");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove (int key) {
        int index = search(key);//查找key的位置
        if(index == -1) {//若key不存在
            System.out.println("No element key");
        }
        for(int i = index;i < this.usedSize - 1;i++) {
            this.elem[i] = this.elem[i + 1];//key元素后的所有元素都往前移位覆盖key
        }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

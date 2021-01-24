class Point<T>{// 此处可以随便写标识符号
    private T x ;
    private T y ;
    public void setX(T x){//作为参数
        this.x = x ;
    }
    public void setY(T y){
        this.y = y ;
    }
    public T getX(){//作为返回值
        return this.x ;
    }
    public T getY(){
        return this.y ;
    }
};

public class Test2 {
    public static void main1(String[] args) {
        //IntegerPoint使用
        Point<Integer> p = new Point<Integer>();
        p.setX(100);
        System.out.println(p.getX());

        //FloatPoint使用
        Point<Float> pp = new Point<Float>();
        pp.setX(100.12f);
        System.out.println(pp.getX());
    }

}

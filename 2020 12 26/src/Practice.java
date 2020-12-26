class Person{
    public String name;
    public int age;
    public String sex;
    public Person(){
        this.name = "玛卡巴卡";
        this.age = 3;
        this.sex = "女";
    }
    public Person(String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void hit() {
        System.out.println(name + "打豆豆");
    }
    public void show(){
        System.out.println("name:" + name + " age:" + age + " sex:" + sex);
    }
}
public class Practice {
    public static void main(String[] args) {
        Person p = new Person();
        Person xdd = new Person("小点点",1,"男" );
        Person ddc = new Person("叮叮车",  2,"女");
        p.hit();
        p.show();
        xdd.hit();
        xdd.show();
        ddc.hit();
        ddc.show();
    }
}

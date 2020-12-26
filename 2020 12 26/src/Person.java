public class Person {

    private String name = "Person";

    int age=0;

    public void show(){
        System.out.println(name);
    }

}
class Child extends Person {

    public String grade;

    public static void main(String[] args){

        Person p = new Child();
        p.show();


    }
}

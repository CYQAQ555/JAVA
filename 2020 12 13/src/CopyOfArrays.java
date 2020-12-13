import java.util.Arrays;

/**
 * 深拷贝：
 * 创建一个新的数组对象，拷贝原有数组中的所有元素到新数组中，修改不影响源对象
 * 本质都是浅拷贝，只不过里面放的是简单类型
 * 若里面是引用类型，都是浅拷贝
 * 浅拷贝：
 * 只拷贝引用不拷贝对象，修改会影响原来对象
 */
public class CopyOfArrays {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] arr = Arrays.copyOf(array1,array1.length);//拷贝数组方式1
        System.out.println(Arrays.toString(arr));
        int[] array2 = new int[array1.length];
        System.arraycopy(array1,0,array2,0,array1.length);//拷贝数组方式2
        System.out.println(Arrays.toString(array2));
        int[] array3 = array1.clone();//拷贝数组方式3
        System.out.println(Arrays.toString(array3));
        //拷贝数组方式4：for循环
    }
}

/**假设有三个分别命名为A,B,C的塔座，在塔座A上插有n个直径大小各不相同，依小到大编号为1，2，…，n的圆盘。现要求将塔座A上的n个圆盘移至塔座C上，并按同样顺序叠排，圆盘移动时必须遵循以下规则：
 *（1）每次只能移动一个圆盘；
 *（2）圆盘可以插在A,B,C中的任一塔座；
 *（3）任何时刻都不能将一个较大的圆盘压在较小的圆盘之上；
 */
public class Hanoi {
    public static void move(char pos1,char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }
    public static void hanoi(int n ,char pos1,char pos2,char pos3) {
        if(n == 1){
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);
    }
    public static void main(String[] args) {
        hanoi(1,'A','B','C');
        //A->C  2^1-1
        System.out.println();
        hanoi(2,'A','B','C');
        //A->B A->C B->C    2^2-1
        System.out.println();
        hanoi(3,'A','B','C');
        //A->C A->B C->B A->C B->A B->C A->C    2^3-1
    }
}

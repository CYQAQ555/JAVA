 import java.util.Scanner;
 public class X{
     public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()){
             int n = scanner.nextInt();
             for(int i = 0;i < n;i++){
                 for(int j = 0;j < n;j++){
                     if(j == i || j == n-i-1){
                         System.out.print("*");
                     }
                     else{
                         System.out.print(" ");
                     }
                 }
                 System.out.println();
             }
         }
     }
 }


import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
        public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0,right = arr.length - 1;
            //先用二分找到最右侧的<=x的元素
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] <= x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            List<Integer> res=new ArrayList<>();
            if(right <= 0) {//若所有数都>=x
                for(int i = 0;i < k;i++) {
                    res.add(arr[i]);
                }
            } else {
                int l = right,r = right + 1;
                while(k > 0 && l >= 0 && r <= arr.length-1) {
                    if(x - arr[l] <= arr[r] - x) {//若arr[l]更接近x
                        res.add(0,arr[l--]);
                    }else{//若arr[r]更接近x
                        res.add(arr[r++]);
                    }
                    k--;
                }
                if(k > 0) {//若还有数没找到
                    if(l == -1) {
                        while(k-- > 0) {
                            res.add(arr[r++]);
                        }
                    }else if(r == arr.length) {
                        while(k-- > 0) {
                            res.add(0,arr[l--]);
                        }
                    }
                }
            }
            return res;
        }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4,x = 1;
        List<Integer> it = findClosestElements(arr,k,x);
        for (Integer integer : it) {
            System.out.println(integer);
        }
    }
}

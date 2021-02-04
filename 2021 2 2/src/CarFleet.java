public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length,len = position.length;
        //计算每辆车在行程内是否能赶上一辆车。若能赶上，总车数减1，遍历完即可。
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (speed[i] <= speed[j] || position[i] > position[j]) {
                    continue;
                }
                //若能追上
                double time = (double) (target - position[j]) / speed[j];
                double time1 = (double) (target - position[i]) / speed[i];
                if (time >= time1) {
                    n--;
                    break;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target,position,speed));
    }
}

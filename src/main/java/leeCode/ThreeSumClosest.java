package leeCode;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * 首先需要判断目标的正负
     * 对象的生命周期：创建-运用-不可见-不可达-收集-销毁
     * 线程的生命周期：创建-就绪-运行-阻塞-睡眠-销毁
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int r;
        if (nums.length > 2) {
            r = target - nums[0] - nums[1] - nums[2];
        } else {
            return -1;
        }
        for (int i = 1; i < nums.length; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < nums.length) {
                int c = nums[i] + nums[left] + nums[right];
                if (c == target) {
                    return target;
                } else if (c < target) {
                    right++;
                } else {
                    left--;
                }
                int curError = target - c;
                r = Math.abs(curError) < Math.abs(r) ? curError : r;
            }
        }
        return target - r;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
//        int[] nums = {-3,-2,-5,3,-4};
        int[] nums = {1,2,5,10,11};
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.println(tsc.threeSumClosest(nums, 12));
    }
}

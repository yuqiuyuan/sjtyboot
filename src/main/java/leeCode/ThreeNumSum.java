package leeCode;

import java.util.*;

public class ThreeNumSum {
    /**
     * 基本方法
     * Time Limited Exceeded
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] <= 0) {
            int num3 = -(nums[left] + nums[right]);//这是要找的第三个数
            if (left + 2 < nums.length && nums[left] == 0 && nums[left + 2] == 0) {
                result.add(Arrays.asList(0, 0, 0));
                break;
            }
            boolean jump = false;
            if (num3 > nums[right]) right = -1;//触发左边指针右移
            else {
                int s = left, e = right, c;
                while ((c = (s + e) / 2) != s) {
                    if (num3 > nums[c]) {
                        s = c;
                    } else if (num3 < nums[c]) {
                        e = c;
                    } else {
                        result.add(Arrays.asList(nums[left], num3, nums[right]));
                        jump = true;
                        break;
                    }
                }
            }
            do {
                right--;
            } while (jump && right >= 0 && nums[right] == nums[right + 1]);
            if (right - left < 2 || nums[right] < 0) {
                do {
                    left++;
                } while (left < nums.length && nums[left] == nums[left - 1]);
                right = nums.length - 1;
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * 需要学习的高效的方法
     * 拿到所找序列中最小的一个数，去找他后面的两个数
     * 左加/右加/左加and右加and去重
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}

package leeCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> r = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int c_target = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1, right = nums.length - 1;
                while (right > left) {
                    int c_c_target = nums[j] + nums[left] + nums[right];
                    if (c_c_target == c_target) {
                        r.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right - 1 >= 0 && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left + 1 < nums.length && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (c_c_target > c_target) {
                        right--;
                    } else {
                        left++;
                    }
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FourNumSum four = new FourNumSum();
//        int[] nums = {1, 0, -1, -1, 0, -2, 2};
        int[] nums = {0, 0, 0, 0};
        System.out.println(four.fourSum(nums, 0));
    }
}

package LeetCodeTest;

import bas.FileUtils;
import leeCode.ThreeNumSum;
import net.sf.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeNumSumTest {
    private static Resource areaRes;

    static {
        areaRes = new ClassPathResource("static/leetCode/ThreeNumSumCase.json");
    }

    public static void main(String[] args) {
        List<int[]> caseList = getData();
        ThreeNumSum t = new ThreeNumSum();
        long start = System.currentTimeMillis();
        caseList.forEach((nums) -> t.threeSum2(nums));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + "ms");
        caseList.forEach((nums) -> t.threeSum(nums));
        long end2 = System.currentTimeMillis();
        System.out.println("time:" + (end2 - end) + "ms");
    }

    private static List<int[]> getData() {
        List<int[]> caseList = new LinkedList<>();
        try {
            JSONObject caseJson = JSONObject.fromObject(FileUtils.toString(areaRes.getFile()));
            Set<String> keySet = caseJson.keySet();
            for (String key : keySet) {
                int[] num = new int[caseJson.getJSONArray(key).size()];
                Object[] array = caseJson.getJSONArray(key).toArray();
                for (int i = 0; i < array.length; i++) {
                    num[i] = (int) array[i];
                }
                caseList.add(num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseList;
    }
}

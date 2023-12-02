package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class E228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList();
        if (nums.length == 0) return ranges;

        int start = 0;
        for(int i=1; i<nums.length; i++) {
            if (nums[i-1]+1 != nums[i]) {

                if (i-start > 1) ranges.add(nums[start] + "->" + nums[i-1]);
                else ranges.add(nums[start]+"");

                start = i;

            }
        }

        if (nums.length-start > 1) ranges.add(nums[start] + "->" + nums[nums.length-1]);
        else ranges.add(String.valueOf(nums[start]));

        return ranges;
    }

    public static void main(String[] strings) {
        int[] nums = {0, 1, 2, 4, 5, 7};

        List<String> res = new E228SummaryRanges().summaryRanges(nums);
        System.out.println(res.get(0).equals("0->2"));
        System.out.println(res.get(1).equals("4->5"));
        System.out.println(res.get(2).equals("7"));
    }
}
